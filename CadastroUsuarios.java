import javax.swing.*;
import java.awt.*;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão: exibir o cadastro com configurações padrão
    public void exibir() {
        criarDialog("Cadastro de Usuários", null, null);
    }

    // Sobrecarga 1: Exibir com título personalizado
    public void exibir(String titulo) {
        criarDialog(titulo, null, null);
    }

    // Sobrecarga 2: Exibir com título e campos pré-preenchidos
    public void exibir(String titulo, String[] dadosPrePreenchidos) {
        criarDialog(titulo, dadosPrePreenchidos, null);
    }

    // Sobrecarga 3: Exibir com título, campos pré-preenchidos e tamanho da janela
    public void exibir(String titulo, String[] dadosPrePreenchidos, Dimension tamanho) {
        criarDialog(titulo, dadosPrePreenchidos, tamanho);
    }

    // Método auxiliar para criar e configurar o JDialog
    private void criarDialog(String titulo, String[] dadosPrePreenchidos, Dimension tamanho) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(tamanho != null ? tamanho : new Dimension(600, 300));
        dialog.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));

        // Campos do formulário
        JTextField txtUsuario = new JTextField(25);
        JPasswordField txtSenha = new JPasswordField(15);
        JTextField txtEmail = new JTextField(30);
        JRadioButton chkAtivo = new JRadioButton();

        // Preencher campos se dados forem fornecidos
        if (dadosPrePreenchidos != null) {
            if (dadosPrePreenchidos.length > 0) txtUsuario.setText(dadosPrePreenchidos[0]);
            if (dadosPrePreenchidos.length > 1) txtSenha.setText(dadosPrePreenchidos[1]);
            if (dadosPrePreenchidos.length > 2) txtEmail.setText(dadosPrePreenchidos[2]);
            if (dadosPrePreenchidos.length > 3) chkAtivo.setSelected(Boolean.parseBoolean(dadosPrePreenchidos[3]));
        }

        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(txtUsuario);
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(txtSenha);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(txtEmail);
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(chkAtivo);

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
