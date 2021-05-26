package br.edu.fatecmm.ContribuicaoInss.view;

import javax.swing.*;
import javax.swing.JTable;

public class GerenciarEmpregadoGUI  {

    private JPanel page;
    private JFrame frame;
    private JTable table;

    public GerenciarEmpregadoGUI() {
        frame = new JFrame();
        frame.setTitle("Gerenciar empregados");

        String[][] data = {
                { "123", "Artur ", "CSE", "10.000", "1,00" }
        };
        createTable(data);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    private void createTable(String[][] data){
        String[] columnNames = { "Código", "Nome", "Setor", "Salário", "Recolhimento" };
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
    }
}
