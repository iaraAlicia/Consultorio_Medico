package Controller;

import Model.DAO.PacienteDAO;
import Model.Paciente;
import View.AgendarPaciente;
import Controller.Helper.PacienteHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PacienteController {
    
    private final AgendarPaciente view;
    private final PacienteDAO pacienteDAO;
    private final PacienteHelper helper;

    public PacienteController(AgendarPaciente view) {
        this.view = view;
        this.pacienteDAO = new PacienteDAO();
        this.helper = new PacienteHelper(view);
    }

    // Método para cadastrar um paciente
    public void cadastrarPaciente() {
        // Obtém os dados preenchidos na View
        Paciente paciente = helper.obterModelo();
        
        // Valida se os campos obrigatórios estão preenchidos
        if (paciente.getNome().isEmpty() || paciente.getTelefone().isEmpty()) {
            view.exibirMensagem("Preencha todos os campos obrigatórios!");
            return;
        }

        // Insere o paciente no banco de dados
        pacienteDAO.insert(paciente);
        
        // Atualiza a tabela da View
        atualizarTabela();
        
        // Limpa os campos do formulário
        helper.limparTela();
        
        // Exibe mensagem de sucesso
        view.exibirMensagem("Paciente cadastrado com sucesso!");
    }

    // Método para atualizar a tabela de pacientes na View
    public void atualizarTabela() {
        // Obtém a lista de pacientes atualizada do banco de dados
        ArrayList<Paciente> listaPacientes = pacienteDAO.selectAll();
        // Atualiza a tabela na View
        helper.preencherTabela(listaPacientes);
    }

    // Método para excluir um paciente
    public void excluirPaciente(String idPacient) {
        // Obtém o paciente selecionado na tabela
        Paciente paciente = helper.obterModelo();
        
        // Remove do banco de dados
        if (pacienteDAO.delete(paciente)) {
            view.exibirMensagem("Paciente removido com sucesso!");
        } else {
            view.exibirMensagem("Erro ao remover paciente!");
        }
        
        // Atualiza a tabela
        atualizarTabela();
        
        helper.limparTela();
    }
    public void atualizarPaciente(Paciente paciente) {
        boolean atualizado = pacienteDAO.update(paciente);
        if (atualizado) {
            view.exibirMensagem("Paciente atualizado com sucesso!");
            atualizarTabela(); // Atualiza a tabela após a edição
        } else {
            view.exibirMensagem("Erro ao atualizar: paciente não encontrado.");
        }
    }
    
    public void limpaTela(){
        helper.limparTela();
    }

    public void preencherCamposComDadosSelecionados() {
        // Obtém o índice da linha selecionada na tabela
        int linhaSelecionada = view.getTabelaPacientes().getSelectedRow();

        // Verifica se há uma linha selecionada
        if (linhaSelecionada >= 0) {
            // Obtém os dados dessa linha
            Paciente pacienteSelecionado = pacienteDAO.selectAll().get(linhaSelecionada);

            // Preenche os campos com os dados do médico selecionado
            view.getTxtId().setText(String.valueOf(pacienteSelecionado.getId())); // ID
            view.getTxtNome().setText(pacienteSelecionado.getNome());
            view.getCmbSexo().setSelectedItem(pacienteSelecionado.getSexo());
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = formato.format(pacienteSelecionado.getDataNascimento());
            view.getTxtDataNascimento().setText(dataFormatada);
            
            view.getTxtTelefone().setText(pacienteSelecionado.getTelefone());
            view.getTxtEmail().setText(pacienteSelecionado.getEmail());
            view.getTxtCpf().setText(pacienteSelecionado.getCPF());
            view.getTxtEndereco().setText(pacienteSelecionado.getEndereco()); 
            view.getTxtIdade().setText(String.valueOf(pacienteSelecionado.getIdade())); // Idade

            // Definir ID e Idade como somente leitura
            view.getTxtId().setEditable(false);
            view.getTxtIdade().setEditable(false);
        } else {
            view.exibirMensagem("Nenhum médico selecionado!");
        }
    }
}
