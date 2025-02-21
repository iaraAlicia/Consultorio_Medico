package Controller.Helper;

import Model.Medico;
import View.CadastrarMedico;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MedicoHelper {
    
    private final CadastrarMedico view;

    public MedicoHelper(CadastrarMedico view) {
        this.view = view;
    }

    // Obtém os dados digitados no formulário e cria um objeto Medico
    public Medico obterModelo() {
        int id = view.getTxtId().getText().isEmpty() ? 0 : Integer.parseInt(view.getTxtId().getText());
        String nome = view.getTxtNome().getText();
        char sexo = view.getCmbSexo().getSelectedItem().toString().charAt(0);
        String dataNascimento = view.getTxtDataNascimento().getText();
        String telefone = view.getTxtTelefone().getText();
        String email = view.getTxtEmail().getText();
        String CPF = view.getTxtCpf().getText();
        String endereco = view.getTxtEndereco().getText();
        int idade = view.getTxtIdade().getText().isEmpty() ? 0 : Integer.parseInt(view.getTxtIdade().getText()); 
        String crm = view.getTxtCrm().getText();
        String especialidade = view.getTxtEspecialidade().getText();
        String dispoDas = view.getTxtDisponibilidadeDas().getText();
        String senha = view.getTxtSenha().getText();
        String acesso = view.getComboBoxAcesso().getSelectedItem().toString();
        
     
        
        return new Medico(id, nome, sexo, dataNascimento,telefone, email, CPF,  endereco, idade, crm, especialidade,dispoDas, senha, acesso);
    }

    // Preenche a tabela da interface com os dados dos medicos
    public void preencherTabela(ArrayList<Medico> listaMedicos) {
        DefaultTableModel modelo = (DefaultTableModel) view.getTabelaMedicos().getModel();
        modelo.setRowCount(0); // Limpa a tabela

        for (Medico medico : listaMedicos) {
            modelo.addRow(new Object[]{
                medico.getId(),
                medico.getNome(),
                medico.getSexo(),
                medico.getDataNascimento(),
                medico.getTelefone(),
                medico.getEmail(),
                medico.getCPF(),
                medico.getEndereco(),
                medico.getIdade(),
                medico.getCRM(),
                medico.getDisponibilidadeHorario(),
                medico.getEspecialidade(),
                medico.getSenha(),
                medico.getAcesso()
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
        view.getTxtCrm().setText("");
        view.getTxtDisponibilidadeDas().setText("");
        view.getTxtDisponibilidadeAs().setText("");
        view.getTxtEspecialidade().setText("");
        view.getTxtSenha().setText("");
        view.getComboBoxAcesso().setSelectedIndex(0);
        
    }
}

