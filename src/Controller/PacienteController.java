package Controller;

import Model.DAO.PacienteDAO;
import Model.Paciente;
import View.AgendarPaciente;
import Controller.Helper.PacienteHelper;
import java.util.ArrayList;

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
        ArrayList<Paciente> listaPacientes = pacienteDAO.selectAll();
        helper.preencherTabela(listaPacientes);
    }

    // Método para excluir um paciente
    public void excluirPaciente() {
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
    }
}
