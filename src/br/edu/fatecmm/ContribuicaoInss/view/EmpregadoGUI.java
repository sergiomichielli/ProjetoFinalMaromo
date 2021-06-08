package br.edu.fatecmm.ContribuicaoInss.view;

import br.edu.fatecmm.ContribuicaoInss.models.Empregado;
import br.edu.fatecmm.ContribuicaoInss.models.GerenciarEmpregado;
import br.edu.fatecmm.ContribuicaoInss.models.Utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        textCodigoEmpregado.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        textSalarioBruto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_COMMA) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
                if (c == KeyEvent.VK_COMMA && textSalarioBruto.getText().contains(",")) {
                    e.consume();
                }
            }
        });

        textlNomeEmpregado.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_SPACE) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        buttonCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (textCodigoEmpregado.getText().isEmpty() || textlNomeEmpregado.getText().isEmpty() || textSalarioBruto.getText().isEmpty() || textSetor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                    return;
                }
                if (labelRecInss.getText().substring(2).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Clique para calcular o recolhimento!");
                    return;
                }
                Empregado e = new Empregado();
                e.setCodigoEmpregado(Integer.parseInt(textCodigoEmpregado.getText()));
                e.setNomeEmpregado(textlNomeEmpregado.getText());
                e.setSetor(textSetor.getText());
                e.setSalarioBruto(Double.parseDouble(textSalarioBruto.getText().replace(",",".")));
                e.setRecInss(Utils.formatarValorStringParaDouble(labelRecInss.getText()));
                ge.adicionarEmpregado(e);

                textCodigoEmpregado.setText("");
                textlNomeEmpregado.setText("");
                textSetor.setText("");
                textSalarioBruto.setText("");
                labelRecInss.setText("R$");
            }
        });

        buttonCalcular.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (textCodigoEmpregado.getText().isEmpty() || textlNomeEmpregado.getText().isEmpty() || textSalarioBruto.getText().isEmpty() || textSetor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                    return;
                }
                Empregado e = new Empregado();
                e.setCodigoEmpregado(Integer.parseInt(textCodigoEmpregado.getText()));
                e.setNomeEmpregado(textlNomeEmpregado.getText());
                e.setSetor(textSetor.getText());
                e.setSalarioBruto(Double.parseDouble(textSalarioBruto.getText().replace(",",".")));

                double valorInss = ge.calcularInss(e);
                labelRecInss.setText(Utils.formatarValorDoubleParaString(valorInss));
            }
        });

        buttonApresentar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (ge.listarEmpregados().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum Funcionário cadastrado!");
                    return;
                }

                GerenciarEmpregadoGUI gerenciarEmpregadoGUI = new GerenciarEmpregadoGUI(ge.listarEmpregados());
                gerenciarEmpregadoGUI.setVisible(true);
            }
        });

        this.setTitle("Cadastro de Empregados");
        this.setSize(700, 400);
        this.setLocation((1366 / 2 - 500 / 2), (768 / 2 - 450 / 2));
        this.setContentPane(CadastroDeEmpregados);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
