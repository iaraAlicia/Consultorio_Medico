package Controller;

import Model.DAO.MedicoDAO;
import Model.Medico;
import Controller.Helper.MedicoHelper;
import View.CadastrarMedico;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MedicoController {
    
    private final CadastrarMedico view;
    private final MedicoDAO medicoDAO;
    private final MedicoHelper helper;

    public MedicoController(CadastrarMedico view) {
        this.view = view;
        this.medicoDAO = new MedicoDAO();
        this.helper = new MedicoHelper(view);
    }

    // Método para cadastrar um medico
    public void cadastrarMedico() {
        // Obtém os dados preenchidos na View
        Medico medico = helper.obterModelo();
        
        // Valida se os campos obrigatórios estão preenchidos
        if (medico.getNome().isEmpty() || medico.getTelefone().isEmpty()) {
            view.exibirMensagem("Preencha todos os campos obrigatórios!");
            return;
        }

        // Insere o medico no banco de dados
        medicoDAO.insert(medico);
        
        // Atualiza a tabela da View
        atualizarTabela();
        
        // Limpa os campos do formulário
        helper.limparTela();
        
        // Exibe mensagem de sucesso
        view.exibirMensagem("Medico cadastrado com sucesso!");
    }

    public void limparTela(){
        helper.limparTela();
    }
    // Método para atualizar a tabela de medicos na View
    public void atualizarTabela() {
        ArrayList<Medico> listaMedicos = medicoDAO.selectAll();
        helper.preencherTabela(listaMedicos);
    }

    // Método para excluir um medico
    public void excluirMedico() {
        // Obtém o medico selecionado na tabela
        Medico medico = helper.obterModelo();
        
        // Remove do banco de dados
        if (medicoDAO.delete(medico)) {
            view.exibirMensagem("Medico removido com sucesso!");
        } else {
            view.exibirMensagem("Erro ao remover medico!");
        }
        
        // Atualiza a tabela
        atualizarTabela();
    }
    public void editarMedico() {
        // Obtém os dados preenchidos nos campos do formulário
        Medico medico = helper.obterModelo();

        // Verifica se os campos obrigatórios estão preenchidos
        if (medico.getNome().isEmpty() || medico.getTelefone().isEmpty()) {
            view.exibirMensagem("Preencha todos os campos obrigatórios!");
            return;
        }

        // Atualiza o médico no banco de dados
        if (medicoDAO.update(medico)) {
            view.exibirMensagem("Médico atualizado com sucesso!");
        } else {
            view.exibirMensagem("Erro ao atualizar médico!");
        }

        // Atualiza a tabela
        atualizarTabela();
    }
    public void preencherCamposComDadosSelecionados() {
        // Obtém o índice da linha selecionada na tabela
        int linhaSelecionada = view.getTabelaMedicos().getSelectedRow();

        // Verifica se há uma linha selecionada
        if (linhaSelecionada >= 0) {
            // Obtém os dados dessa linha
            Medico medicoSelecionado = medicoDAO.selectAll().get(linhaSelecionada);

            // Preenche os campos com os dados do médico selecionado
            view.getTxtId().setText(String.valueOf(medicoSelecionado.getId())); // ID
            view.getTxtNome().setText(medicoSelecionado.getNome());
            view.getCmbSexo().setSelectedItem(medicoSelecionado.getSexo());
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formato.format(medicoSelecionado.getDataNascimento());
            view.getTxtDataNascimento().setText(dataFormatada);
            
            view.getTxtTelefone().setText(medicoSelecionado.getTelefone());
            view.getTxtEmail().setText(medicoSelecionado.getEmail());
            view.getTxtCpf().setText(medicoSelecionado.getCPF());
            view.getTxtCrm().setText(medicoSelecionado.getCRM());
            view.getTxtEspecialidade().setText(medicoSelecionado.getEspecialidade());
            view.getTxtDisponibilidadeDas().setText(medicoSelecionado.getDisponibilidadeHorario());
            view.getTxtEndereco().setText(medicoSelecionado.getEndereco()); 
            view.getTxtIdade().setText(String.valueOf(medicoSelecionado.getIdade())); // Idade
            view.getTxtSenha().setText(String.valueOf(medicoSelecionado.getSenha())); // senha

            // Definir ID e Idade como somente leitura
            view.getTxtId().setEditable(false);
            view.getTxtIdade().setEditable(false);
        } else {
            view.exibirMensagem("Nenhum médico selecionado!");
        }
    }



    
    
}
