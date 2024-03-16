import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Login extends JFrame {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;

    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250); // Tamanho ajustável
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        // Painel para campos de entrada e botão
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        add(panel, BorderLayout.CENTER);

        JLabel labelUsuario = new JLabel("Usuário:");
        panel.add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setPreferredSize(new Dimension(25, 25));
        panel.add(textFieldUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        panel.add(labelSenha);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setPreferredSize(new Dimension(25, 25));
        panel.add(passwordFieldSenha);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener((ActionEvent e) -> {
            String usuario = textFieldUsuario.getText();
            String senha = new String(passwordFieldSenha.getPassword());
            
            JOptionPane.showMessageDialog(Login.this, "Usuário: " + usuario + "\nSenha: " + senha,
                    "Informações de Login", JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(btnOK);

        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("logoifmt.png"));
            int newWidth = 190; // Novo largura da imagem
            int newHeight = 200; // Nova altura da imagem
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            JLabel labelImagem = new JLabel(icon);
            add(labelImagem, BorderLayout.WEST); // Adicionando à direita da tela
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}
