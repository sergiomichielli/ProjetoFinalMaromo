package br.edu.fatecmm.ContribuicaoInss.view;

import br.edu.fatecmm.ContribuicaoInss.models.Empregado;
import br.edu.fatecmm.ContribuicaoInss.models.GerenciarEmpregado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class GerenciarEmpregadoGUI extends JFrame {

    private JPanel page;
    private JTable table;
//    private ArrayList <Empregado> listaEmpregado;

    public GerenciarEmpregadoGUI(ArrayList<Empregado> listaEmpregado) {
        this.setTitle("Gerenciar empregados");
        this.setLocation((1366/2 - 500/2), (768/2 -450/2));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        createTable(listaEmpregado);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
        this.setSize(700, 400);
    }

    private void createTable(ArrayList<Empregado> listaEmpregado) {
        String[] columnNames = {"Código", "Nome", "Setor", "Salário", "Recolhimento"};

        DefaultTableModel tTabela = (DefaultTableModel) table.getModel();
        tTabela.setNumRows(0);
        tTabela.setColumnIdentifiers(columnNames);
        for (int linha = 0; linha < listaEmpregado.size(); linha++) {
            Empregado empregado = listaEmpregado.get(linha);

            tTabela.addRow(new Object[]{1});

            table.setValueAt(empregado.getCodigoEmpregado(), linha, 0);
            table.setValueAt(empregado.getNomeEmpregado(), linha, 1);
            table.setValueAt(empregado.getSetor(), linha, 2);
            table.setValueAt(empregado.getSalarioBruto(), linha, 3);
            table.setValueAt(empregado.getRecInss(), linha, 4);
        }

    }

}
