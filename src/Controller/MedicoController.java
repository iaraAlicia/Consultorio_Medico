package Controller;

import Model.DAO.MedicoDAO;
import Model.Medico;
import Controller.Helper.MedicoHelper;
import View.CadastrarMedico;
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
}
