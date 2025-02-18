package Controller.Helper;

import Model.Administrador;
import View.Login;

public class LoginHelper implements IHelper {
    private final Login view; // Referência à tela de login

    // Construtor que recebe a tela de login
    public LoginHelper(Login view) {
        this.view = view;
    }

    /*
     * Obtém os dados inseridos pelo usuário na interface gráfica e os transforma 
     * em um objeto Administrador para validação no banco de dados.
     */
    public Administrador obterModelo(){
        String nome = view.getTextUsuario().getText(); // Obtém o nome de usuário da view
        String senha = view.getTextSenha().getText(); // Obtém a senha da view

        // Retorna um objeto Administrador com os dados preenchidos (ID fixo como 0)
        return new Administrador(0, senha, nome);
    }

    /*
     * Define os campos da tela de login com os dados de um Administrador.
     * Útil caso seja necessário preencher os campos com informações existentes.
     */
    public void setModelo(Administrador modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();

        // Define os valores dos campos na interface gráfica
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }

    /*
     * Método que limpa os campos da interface gráfica após um login malsucedido
     * ou quando o usuário desejar reiniciar a entrada de dados.
     */
    public void limparTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
}
