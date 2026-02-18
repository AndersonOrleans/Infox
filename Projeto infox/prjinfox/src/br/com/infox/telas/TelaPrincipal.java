package br.com.infox.telas;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JLabel lblData;

    // 🔥 ACESSO PÚBLICO E ESTÁTICO
    public static JMenuItem MenCadUsu;
    public static JMenu MenRel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaPrincipal frame = new TelaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaPrincipal() {

        setResizable(false);
        setTitle("SUL TECH - Tela principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1208, 740);

        // ------------------- MENU -------------------
        JMenuBar Menu = new JMenuBar();
        setJMenuBar(Menu);

        JMenu menCad = new JMenu("Cadastro");
        Menu.add(menCad);

        JMenuItem MenCadCli = new JMenuItem("Cliente");
        MenCadCli.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
        menCad.add(MenCadCli);

        JMenuItem MenCadOs = new JMenuItem("OS");
        MenCadOs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
        menCad.add(MenCadOs);

        // 🔥 ITEM PÚBLICO E ESTÁTICO
        MenCadUsu = new JMenuItem("Usuários");
        MenCadUsu.setEnabled(false);
        MenCadUsu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
        menCad.add(MenCadUsu);

        // 🔥 MENU RELATÓRIO PÚBLICO E ESTÁTICO
        MenRel = new JMenu("Relatório");
        MenRel.setEnabled(false);
        Menu.add(MenRel);

        JMenuItem MenRelSer = new JMenuItem("Serviços");
        MenRelSer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
        MenRel.add(MenRelSer);

        JMenu MenAju = new JMenu("Ajuda");
        Menu.add(MenAju);

        JMenuItem MenAjuSob = new JMenuItem("Sobre");
        MenAjuSob.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_DOWN_MASK));
        MenAju.add(MenAjuSob);

        MenAjuSob.addActionListener(evt -> MenAjuSobActionPerformed(evt));

        JMenu MenOpc = new JMenu("Opções");
        Menu.add(MenOpc);

        JMenuItem MenOpcSai = new JMenuItem("Sair");
        MenOpcSai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        MenOpc.add(MenOpcSai);

        MenOpcSai.addActionListener(evt -> MenOpcSaiActionPerformed(evt));

        // ------------------- CONTENT -------------------
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel Desktop = new JPanel();
        Desktop.setBounds(10, 11, 797, 657);
        Desktop.setBackground(new Color(223, 223, 223));
        contentPane.add(Desktop);
        Desktop.setLayout(null);

        JLabel lblNewLabel = new JLabel("SUL");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 29));
        lblNewLabel.setBounds(944, 588, 46, 44);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("TECH");
        lblNewLabel_1.setForeground(new Color(0, 128, 64));
        lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 29));
        lblNewLabel_1.setBounds(993, 588, 68, 44);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("INFORMÁTICA E CELULARES");
        lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(944, 621, 200, 18);
        contentPane.add(lblNewLabel_2);

        lblData = new JLabel("Data");
        lblData.setFont(new Font("Calibri", Font.BOLD, 20));
        lblData.setBounds(908, 161, 200, 25);
        contentPane.add(lblData);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent evt) {
                Date data = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                lblData.setText(formato.format(data));
            }
        });
    }

    // ------------------- MÉTODO SAIR -------------------
    private void MenOpcSaiActionPerformed(java.awt.event.ActionEvent evt) {

        Object[] opcoes = { "Sim", "Não" };

        int sair = JOptionPane.showOptionDialog(
                null,
                "Tem certeza que deseja sair?",
                "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // ------------------- MÉTODO SOBRE -------------------
    private void MenAjuSobActionPerformed(java.awt.event.ActionEvent evt) {

        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }
}
