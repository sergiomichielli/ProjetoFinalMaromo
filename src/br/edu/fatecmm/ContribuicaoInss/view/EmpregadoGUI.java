package br.edu.fatecmm.ContribuicaoInss.view;

import javax.swing.*;

public class EmpregadoGUI extends JFrame {

    private JPanel CadastroDeEmpregados;
    private JTextField labelCodigoEmpregado;
    private JTextField labelNomeEmpregado;
    private JTextField labelSetor;
    private JTextField labelSalarioBruto;
    private JButton buttoncalcular;
    private JButton buttonapresentar;
    private JButton buttoncadastrar;
    private JLabel textCodigoEmpregado;
    private JLabel textNomeEmpregado;
    private JLabel textSetor;
    private JLabel textsalario;
    private JLabel labelRecolhimento;
    private JLabel labelValorCalculado;
    private JPanel painelEmpregado;
    private JPanel painelButton;

    public EmpregadoGUI() {
        this.setTitle("Cadastro de Empregados");
        this.setSize(500, 200);

        this.add(labelCodigoEmpregado);

        this.setContentPane(CadastroDeEmpregados);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
