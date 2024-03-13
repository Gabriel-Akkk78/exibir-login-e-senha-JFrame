import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150); // Tamanho ajustável
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Painel para campos de entrada e botão
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        add(panel, BorderLayout.CENTER);

        JLabel labelUsuario = new JLabel("Usuário:");
        panel.add(labelUsuario);

        textFieldUsuario = new JTextField();
        panel.add(textFieldUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        panel.add(labelSenha);

        passwordFieldSenha = new JPasswordField();
        panel.add(passwordFieldSenha);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldUsuario.getText();
                String senha = new String(passwordFieldSenha.getPassword());

                JOptionPane.showMessageDialog(LoginForm.this, "Usuário: " + usuario + "\nSenha: " + senha,
                        "Informações de Login", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(btnOK);

        // Adicionando a imagem à direita da tela
        ImageIcon icon = new ImageIcon("reitoria_instituto_federal_mato_grosso_rgb_vertical.png");
        JLabel labelImagem = new JLabel(icon);
        add(labelImagem, BorderLayout.WEST); // Ajuste conforme necessário

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm();
            }
        });
    }
}