package Controller;

import Controller.Helper.LoginHelper;
import Model.Administrador;
import Model.DAO.AdministradorDAO;
import View.Login;
import View.MenuPrincipal;

public class LoginController {

    private final Login view; // Referência à tela de login
    private final LoginHelper helper; // Helper para manipular os dados da view

    // Construtor que recebe a tela de login e inicializa o helper
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    /*
     * Método responsável por validar as credenciais e permitir a entrada no sistema.
     * Caso os dados estejam corretos, o usuário será redirecionado ao menu principal.
     */
    public void entraNoSistema() {
        // Obtém os dados de login informados na view
        Administrador adm = helper.obterModelo();
        
        // Acessa o banco de dados para verificar se o usuário e senha existem
        AdministradorDAO AdministradorDAO = new AdministradorDAO();
        Administrador admAutenticado = AdministradorDAO.selectPorNomeESenha(adm);

        if (admAutenticado != null) { // Se encontrou o usuário
            String nivelAcesso = admAutenticado.getAcesso(); // Obtém nível de acesso
            
            // Abre o menu principal passando o nível de acesso
            MenuPrincipal menu = new MenuPrincipal(nivelAcesso);
            menu.setVisible(true);
            
            // Fecha a tela de loginz
            this.view.dispose();
        } else {
            // Exibe mensagem de erro se as credenciais forem inválidas
            view.exibeMensagem("Usuário ou senha incorretos");
        }
    }
}
