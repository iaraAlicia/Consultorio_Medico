package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    private List<Agendamento> agendamentos;

    public AgendaDAO() {
        this.agendamentos = BancoJSON.carregar();
    }

    public void insert(Agendamento agendamento) {
        if (agendamento.getId() == 0) {
            agendamento.setId(proximoId());
        }
        agendamentos.add(agendamento);
        BancoJSON.salvar(agendamentos);
    }

    public boolean update(Agendamento agendamento) {
        for (int i = 0; i < agendamentos.size(); i++) {
            if (idSaoIguais(agendamentos.get(i), agendamento)) {
                agendamentos.set(i, agendamento);
                BancoJSON.salvar(agendamentos);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Agendamento agendamento) {
        if (agendamentos.removeIf(a -> idSaoIguais(a, agendamento))) {
            BancoJSON.salvar(agendamentos);
            return true;
        }
        return false;
    }

    public ArrayList<Agendamento> selectAll() {
        return new ArrayList<>(agendamentos);
    }

    private boolean idSaoIguais(Agendamento a1, Agendamento a2) {
        return a1.getId() == a2.getId();
    }

    private int proximoId() {
        return agendamentos.stream().mapToInt(Agendamento::getId).max().orElse(0) + 1;
    }
}
