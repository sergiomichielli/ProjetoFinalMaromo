package br.edu.fatecmm.ContribuicaoInss.view;

import br.edu.fatecmm.ContribuicaoInss.models.Empregado;

import javax.swing.*;
import java.util.ArrayList;

public class GerenciarEmpregadoGUI extends JFrame  {

    private JPanel page;
    private JTable table;
    private static ArrayList <Empregado> listaEmpregado;

    public GerenciarEmpregadoGUI(ArrayList <Empregado> listaEmpregado) {
        this.setTitle("Gerenciar empregados");

        listaEmpregado.toString(data);


        createTable(data);
        JScrollPane sp = new JScrollPane(table);
        this.add(sp);
        this.setSize(500, 200);
    }

    private void createTable(String[][] data){
        String[] columnNames = { "Código", "Nome", "Setor", "Salário", "Recolhimento" };
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
    }
}
