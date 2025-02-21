/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.PacienteController;
import Model.DAO.Banco;
import static Model.DAO.Banco.paciente;
import Model.Paciente;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author iara4
 */
public class AgendarPaciente extends javax.swing.JFrame {

    private final PacienteController controller;
    
    private String idPacienteSelecionado;  
    /**
     * Creates new form Consulta
     * @throws java.text.ParseException
     */
    public AgendarPaciente() throws ParseException {
        initComponents();
        this.controller = new PacienteController(this);
        Banco.inicia();
        iniciar();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaPacientes = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtEndereco = new javax.swing.JTextField();
        CmbSexo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        TxtTelefone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtIdade = new javax.swing.JTextField();
        TxtId = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtCpf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        TxtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela medico");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 186, 660, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 160, 490));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Telefone:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        TabelaPacientes.setBackground(new java.awt.Color(255, 255, 255));
        TabelaPacientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TabelaPacientes.setForeground(new java.awt.Color(0, 0, 0));
        TabelaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Sexo", "DataNascimento", "Telefone", "Email", "CPF", "Endereço", "idade"
            }
        ));
        TabelaPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaPacientes.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(TabelaPacientes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 600, 110));

        btnSalvar.setBackground(new java.awt.Color(204, 255, 255));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(0, 0, 0));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save32.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 50, 50));

        btnEditar.setBackground(new java.awt.Color(204, 255, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 50, 50));

        btnExcluir.setBackground(new java.awt.Color(204, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 50, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search24.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sexo");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        TxtEndereco.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 510, 30));

        CmbSexo.setBackground(new java.awt.Color(204, 204, 204));
        CmbSexo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CmbSexo.setForeground(new java.awt.Color(51, 51, 51));
        CmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        getContentPane().add(CmbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackgroundBlue.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, -20, 160, 510));

        TxtNome.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 510, 30));

        TxtTelefone.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 170, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Idade:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 40, -1));

        TxtIdade.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 120, 30));

        TxtId.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 60, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CPF:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        TxtCpf.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 170, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("* Campos obrigatorios");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Endereço:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jTextFieldId.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 270, 30));

        TxtEmail.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 510, 30));

        TxtDataNascimento.setBackground(new java.awt.Color(255, 255, 255));
        TxtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        TxtDataNascimento.setToolTipText("");
        getContentPane().add(TxtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 120, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("DataNacimento:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 100, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Email:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackgroundBlue.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 660, 300));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consulta_painelFundo.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 660, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 70, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BackgroundMenuPrincipal.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 490));

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.controller.cadastrarPaciente(); //clicar no botão chama cadastrar paciente
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.controller.excluirPaciente(idPacienteSelecionado);

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Paciente paciente = new Paciente(
            Integer.parseInt(TxtId.getText()),
            TxtNome.getText(),
            CmbSexo.getSelectedItem().toString().charAt(0),
            TxtDataNascimento.getText(),   
            TxtTelefone.getText(),
            TxtEmail.getText(),
            TxtCpf.getText(),
            TxtEndereco.getText(),
            Integer.parseInt(TxtIdade.getText())
        );
        controller.atualizarPaciente(paciente);
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AgendarPaciente().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(AgendarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbSexo;
    private javax.swing.JTable TabelaPacientes;
    private javax.swing.JTextField TxtCpf;
    private javax.swing.JFormattedTextField TxtDataNascimento;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtEndereco;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtIdade;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtTelefone;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables


    
       
    private void iniciar() {
       this.controller.atualizarTabela();
        TabelaPacientes.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            this.controller.preencherCamposComDadosSelecionados();
        }
        });
    }  
    
    public JTextField getTxtEndereco() {
        return TxtEndereco;
    }

    public void setTxtEndereco(JTextField TxtEndereco) {
        this.TxtEndereco = TxtEndereco;
    }

    public JTextField getTxtId() {
        return TxtId;
    }

    public void setTxtId(JTextField TxtId) {
        this.TxtId = TxtId;
    }

    public JTextField getTxtNome() {
        return TxtNome;
    }

    public void setTxtNome(JTextField TxtNome) {
        this.TxtNome = TxtNome;
    }

    public JTextField getTxtTelefone() {
        return TxtTelefone;
    }

    public void setTxtTelefone(JTextField TxtTelefone) {
        this.TxtTelefone = TxtTelefone;
    }

    public JTable getTabelaPacientes() {
        return TabelaPacientes;
    }

    public void setTabelaPacientes(JTable TabelaPacientes) {
        this.TabelaPacientes = TabelaPacientes;
    }
    

    public JComboBox<String> getCmbSexo() {
        return CmbSexo;
    }

    public void setCmbSexo(JComboBox<String> CmbSexo) {
        this.CmbSexo = CmbSexo;
    }

    public JTextField getTxtCpf() {
        return TxtCpf;
    }

    public void setTxtCpf(JTextField TxtCpf) {
        this.TxtCpf = TxtCpf;
    }

    public JFormattedTextField getTxtDataNascimento() {
        return TxtDataNascimento;
    }

    public void setTxtDataNascimento(JFormattedTextField TxtDataNascimento) {
        this.TxtDataNascimento = TxtDataNascimento;
    }

    public JTextField getTxtEmail() {
        return TxtEmail;
    }

    public void setTxtEmail(JTextField TxtEmail) {
        this.TxtEmail = TxtEmail;
    }

    public JTextField getTxtIdade() {
        return TxtIdade;
    }

    public void setTxtIdade(JTextField TxtIdade) {
        this.TxtIdade = TxtIdade;
    }
    

    public void exibirMensagem(String mensagem) {
        javax.swing.JOptionPane.showMessageDialog(this, mensagem);
    }
    
    private void excluirPaciente() {
        if (idPacienteSelecionado != null) {
            // Chama o método do controlador para excluir o paciente
            controller.excluirPaciente(idPacienteSelecionado);

            // Atualiza a tabela após a exclusão
            controller.atualizarTabela();

            // Limpa os campos
            TxtNome.setText("");
            CmbSexo.setSelectedIndex(0);  // Ou o valor padrão
            TxtDataNascimento.setText("");
            TxtTelefone.setText("");
            TxtEmail.setText("");
            TxtCpf.setText("");
            TxtEndereco.setText("");
            TxtIdade.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um paciente para excluir.");
        }
    }
    
 
    


}
