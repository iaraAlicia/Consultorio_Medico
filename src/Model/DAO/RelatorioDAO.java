package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {
    
    private final List<Agendamento> agendamentos;

    public RelatorioDAO() {
        this.agendamentos = new AgendaDAO().selectAll();
    }

    public ArrayList<Agendamento> gerarRelatorio() {
        return new ArrayList<>(agendamentos);
    }
}
