import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {

    private JTextField usuarioField;
    private JPasswordField senhaField;

    public AcessoAplicativo() {
        setTitle("Acesso ao Aplicativo");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Criar componentes
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioField = new JTextField(15);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(15);
        
        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");
        
        // Adicionar ação ao botão Confirmar
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());
                
                if (usuario.equals("denys.silva") && senha.equals("Teste@2024")) {
                    JOptionPane.showMessageDialog(AcessoAplicativo.this, "Acesso confirmado!");
                    System.exit(0); // Fecha o aplicativo
                } else {
                    JOptionPane.showMessageDialog(AcessoAplicativo.this, "Usuário ou senha inválido!");
                }
            }
        });
        
        // Adicionar ação ao botão Cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha o aplicativo
            }
        });
        
        // Criar um painel e adicionar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(confirmarButton);
        panel.add(cancelarButton);
        
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AcessoAplicativo app = new AcessoAplicativo();
            app.setVisible(true);
        });
    }
}