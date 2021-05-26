package br.edu.fatecmm.ContribuicaoInss.view;

import javax.swing.*;

public class GerenciarEmpregadoGUI extends JFrame  {

    private JPanel page;
    private JTable table;

    public GerenciarEmpregadoGUI() {
        this.setTitle("Gerenciar empregados");

        String[][] data = {
                { "123", "Artur ", "CSE", "10.000", "1,00" }
        };
        createTable(data);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
        this.setSize(500, 200);
        this.setVisible(true);
    }

    private void createTable(String[][] data){
        String[] columnNames = { "Código", "Nome", "Setor", "Salário", "Recolhimento" };
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
    }
}
