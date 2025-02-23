package Controller;

import Model.Agendamento;
import Model.DAO.RelatorioDAO;
import View.Relatorio;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class RelatorioController {
    
    private final Relatorio view;

    public RelatorioController(Relatorio view) {
        this.view = view;
    }

    public void preencherTabela() {
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        ArrayList<Agendamento> listaAgendamentos = relatorioDAO.gerarRelatorio();

        DefaultTableModel modeloTabela = (DefaultTableModel) view.getjTableAgendamentos().getModel();
        modeloTabela.setRowCount(0); // Limpa a tabela antes de preencher

        for (Agendamento agendamento : listaAgendamentos) {
            modeloTabela.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getMedico().getMedico().getNome(),
                agendamento.getPaciente().getNome(),
                agendamento.getMedico().getValor(),
                agendamento.getDataFormatada(),
                agendamento.getObservacao()
            });
        }
    }
}
