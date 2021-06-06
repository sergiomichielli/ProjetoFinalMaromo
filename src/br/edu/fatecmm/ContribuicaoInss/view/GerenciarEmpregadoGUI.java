package br.edu.fatecmm.ContribuicaoInss.view;

import br.edu.fatecmm.ContribuicaoInss.models.Empregado;
import br.edu.fatecmm.ContribuicaoInss.models.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class GerenciarEmpregadoGUI extends JFrame {

    private JPanel page;
    private JTable table;

    public GerenciarEmpregadoGUI(ArrayList<Empregado> listaEmpregado) {
        this.setTitle("Gerenciar empregados");

        createTable(listaEmpregado);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
        this.setSize(500, 200);
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
            table.setValueAt(Utils.formatarValorDoubleParaString(empregado.getSalarioBruto()), linha, 3);
            table.setValueAt(Utils.formatarValorDoubleParaString(empregado.getRecInss()), linha, 4);
        }
    }
}
