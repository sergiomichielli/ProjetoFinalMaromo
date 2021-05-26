package br.edu.fatecmm.ContribuicaoInss.view;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GerenciarEmpregadoGUI extends JFrame {
    private JPanel panel1;
    private JTable table1;

    private void createUIComponents() {
        Dimension frameDimension = new Dimension(400, 400);

        JFrame tela = new JFrame();
        tela.setContentPane(new JPanel());
        tela.setTitle("Gerenciar Empregados");
        tela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tela.setVisible(true);

         createTable();
        // TODO: place custom component creation code here
    }


    private void createTable(){
        table1.setModel(new DefaultTableModel(null, new String[] {"Código", "Nome", "Setor", "Salário", "Recolhimento" }));
        this.add(table1);
    }
}
