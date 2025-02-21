package Controller.Helper;

import Model.Paciente;
import View.AgendarPaciente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PacienteHelper {
    
    private final AgendarPaciente view;

    public PacienteHelper(AgendarPaciente view) {
        this.view = view;
    }

    // Obtém os dados digitados no formulário e cria um objeto Paciente
    public Paciente obterModelo() {
        int id = view.getTxtId().getText().isEmpty() ? 0 : Integer.parseInt(view.getTxtId().getText());
        String nome = view.getTxtNome().getText();
        char sexo = view.getCmbSexo().getSelectedItem().toString().charAt(0);
        String dataNascimento = view.getTxtDataNascimento().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        String CPF = view.getTxtCpf().getText();
        String endereco = view.getTxtEndereco().getText();
        int idade = view.getTxtIdade().getText().isEmpty() ? 0 : Integer.parseInt(view.getTxtIdade().getText()); 
     
        
        return new Paciente(id, nome, sexo, dataNascimento, telefone, email, CPF,  endereco, idade);
    }

    // Preenche a tabela da interface com os dados dos pacientes
    public void preencherTabela(ArrayList<Paciente> listaPacientes) {
        DefaultTableModel modelo = (DefaultTableModel) view.getTabelaPacientes().getModel();
        modelo.setRowCount(0); // Limpa a tabela

        for (Paciente paciente : listaPacientes) {
            modelo.addRow(new Object[]{
                paciente.getId(),
                paciente.getNome(),
                paciente.getSexo(),
                paciente.getDataNascimento(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getCPF(),
                paciente.getEndereco(),
                paciente.getIdade()
            });
        }
    }

    // Limpa os campos da tela após o cadastro
    public void limparTela() {
        view.getTxtId().setText("0");
        view.getTxtNome().setText("");
        view.getTxtDataNascimento().setText("");
        view.getTxtTelefone().setText("");
        view.getTxtEmail().setText("");
        view.getTxtCpf().setText("");
        view.getTxtEndereco().setText("");
        view.getTxtIdade().setText("");
        view.getCmbSexo().setSelectedIndex(0);
    }
}

