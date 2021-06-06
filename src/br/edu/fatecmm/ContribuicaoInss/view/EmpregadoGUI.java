package br.edu.fatecmm.ContribuicaoInss.view;

import br.edu.fatecmm.ContribuicaoInss.models.Empregado;
import br.edu.fatecmm.ContribuicaoInss.models.GerenciarEmpregado;
import br.edu.fatecmm.ContribuicaoInss.models.Utils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpregadoGUI extends JFrame {


    private JPanel CadastroDeEmpregados;
    private JTextField textCodigoEmpregado;
    private JTextField textlNomeEmpregado;
    private JTextField textSetor;
    private JTextField textSalarioBruto;
    private JButton buttonCalcular;
    private JButton buttonApresentar;
    private JButton buttonCadastrar;
    private JLabel labelCodigoEmpregado;
    private JLabel labelNomeEmpregado;
    private JLabel labelSetor;
    private JLabel labelSalarioBruto;
    private JLabel labelRecolhimento;
    private JLabel labelRecInss;
    private JPanel painelEmpregado;
    private JPanel painelButton;
    private GerenciarEmpregado ge = new GerenciarEmpregado();

    public EmpregadoGUI() {

        buttonCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Empregado e = new Empregado();
                e.setCodigoEmpregado(Integer.parseInt(textCodigoEmpregado.getText()));
                e.setNomeEmpregado(textlNomeEmpregado.getText());
                e.setSetor(textSetor.getText());
                e.setSalarioBruto(Double.parseDouble(textSalarioBruto.getText()));
                e.setRecInss(Utils.formatarValorStringParaDouble(labelRecInss.getText()));
                ge.adicionarEmpregado(e);

                textCodigoEmpregado.setText("");
                textlNomeEmpregado.setText("");
                textSetor.setText("");
                textSalarioBruto.setText("");
            }
        });

        buttonApresentar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
            GerenciarEmpregadoGUI gerenciarEmpregadoGUI = new GerenciarEmpregadoGUI(ge.listarEmpregados());
            gerenciarEmpregadoGUI.setVisible(true);
            }
        });

        buttonCalcular.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Empregado e = new Empregado();
                e.setCodigoEmpregado(Integer.parseInt(textCodigoEmpregado.getText()));
                e.setNomeEmpregado(textlNomeEmpregado.getText());
                e.setSetor(textSetor.getText());
                e.setSalarioBruto(Double.parseDouble(textSalarioBruto.getText()));

                double valorInss = ge.calcularInss(e);
                labelRecInss.setText(Utils.formatarValorDoubleParaString(valorInss));
            }
        });

        this.setTitle("Cadastro de Empregados");
        this.setSize(500, 200);
        this.setContentPane(CadastroDeEmpregados);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
