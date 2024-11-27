import javax.swing.*;
import java.awt.*;

public class CadastroPessoas {
    private final JFrame principal;

    public CadastroPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão: exibir formulário com configurações padrão
    public void exibir() {
        criarDialog("Cadastro de Pessoas", null, null);
    }

    // Sobrecarga 1: Exibir com título personalizado
    public void exibir(String titulo) {
        criarDialog(titulo, null, null);
    }

    // Sobrecarga 2: Exibir com título e dados pré-preenchidos
    public void exibir(String titulo, String[] dadosPrePreenchidos) {
        criarDialog(titulo, dadosPrePreenchidos, null);
    }

    // Sobrecarga 3: Exibir com título, dados pré-preenchidos e tamanho personalizado
    public void exibir(String titulo, String[] dadosPrePreenchidos, Dimension tamanho) {
        criarDialog(titulo, dadosPrePreenchidos, tamanho);
    }

    // Método privado auxiliar para criar o diálogo
    private void criarDialog(String titulo, String[] dadosPrePreenchidos, Dimension tamanho) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(tamanho != null ? tamanho : new Dimension(600, 300));
        dialog.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));

        // Campos do formulário
        JTextField txtNome = new JTextField(40);
        JTextField txtEndereco = new JTextField(60);
        JTextField txtCidade = new JTextField(40);
        JTextField txtUF = new JTextField(2);
        JTextField txtEmail = new JTextField(30);
        JTextField txtTelefone = new JTextField(20);
        JComboBox<String> cmbSexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});

        // Preencher campos se dados forem fornecidos
        if (dadosPrePreenchidos != null) {
            if (dadosPrePreenchidos.length > 0) txtNome.setText(dadosPrePreenchidos[0]);
            if (dadosPrePreenchidos.length > 1) txtEndereco.setText(dadosPrePreenchidos[1]);
            if (dadosPrePreenchidos.length > 2) txtCidade.setText(dadosPrePreenchidos[2]);
            if (dadosPrePreenchidos.length > 3) txtUF.setText(dadosPrePreenchidos[3]);
            if (dadosPrePreenchidos.length > 4) txtEmail.setText(dadosPrePreenchidos[4]);
            if (dadosPrePreenchidos.length > 5) txtTelefone.setText(dadosPrePreenchidos[5]);
            if (dadosPrePreenchidos.length > 6) cmbSexo.setSelectedItem(dadosPrePreenchidos[6]);
        }

        // Adicionar os campos ao painel
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(txtEndereco);
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(txtCidade);
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(txtUF);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(txtEmail);
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(txtTelefone);
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(cmbSexo);

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}

// Classe auxiliar para criar o painel de botões
class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    public JPanel criar() {
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        // Ações dos botões
        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(dialog, "Dados salvos com sucesso!");
            dialog.setVisible(false);
        });

        btnCancelar.addActionListener(e -> dialog.setVisible(false));

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        return painelBotoes;
    }
}
