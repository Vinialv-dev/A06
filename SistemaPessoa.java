import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaPessoa {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaPrincipal().setVisible(true));
    }
}

class JanelaPrincipal extends JFrame {

    private JLabel rodape;

    public JanelaPrincipal() {
        setTitle("Sistema de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar menu
        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuarios = new JMenuItem("Usuários");
        menuUsuarios.addActionListener(e -> new JanelaCadastroUsuario().setVisible(true));
        JMenuItem menuPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(menuUsuarios);
        menuCadastro.add(menuPessoas);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuListaUsuarios = new JMenuItem("Lista de Usuários");
        JMenuItem menuListaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(menuListaUsuarios);
        menuVisualizacao.add(menuListaPessoas);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuSairItem = new JMenuItem("Sair");
        menuSairItem.addActionListener(e -> System.exit(0));
        menuSair.add(menuSairItem);

        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        // Criar rodapé com informações
        String usuario = "Nome do Usuário"; // Substitua pelo nome real do usuário
        String versao = "1.0";
        String dataHora = obterDataHoraAtual();

        rodape = new JLabel("Versão: " + versao + " | Usuário: " + usuario + " | Data: " + dataHora, JLabel.CENTER);
        add(rodape, BorderLayout.SOUTH);
    }

    private String obterDataHoraAtual() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return agora.format(formato);
    }
}

class JanelaCadastroUsuario extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JTextField campoEmail;
    private JComboBox<String> comboStatus;

    public JanelaCadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(350, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adiciona componentes à janela com GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        add(new JLabel("Usuário:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        campoUsuario = new JTextField();
        add(campoUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Senha:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        campoSenha = new JPasswordField();
        add(campoSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        campoEmail = new JTextField();
        add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        String[] statusOptions = {"Ativo", "Inativo"};
        comboStatus = new JComboBox<>(statusOptions);
        add(comboStatus, gbc);

        // Botões de ação
        JPanel panelBotoes = new JPanel();
        JButton botaoIncluir = new JButton("Incluir");
        botaoIncluir.addActionListener(e -> incluirUsuario());
        panelBotoes.add(botaoIncluir);

        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.addActionListener(e -> alterarUsuario());
        panelBotoes.add(botaoAlterar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(e -> excluirUsuario());
        panelBotoes.add(botaoExcluir);

        JButton botaoConsultar = new JButton("Consultar");
        botaoConsultar.addActionListener(e -> consultarUsuario());
        panelBotoes.add(botaoConsultar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> cancelarCadastro());
        panelBotoes.add(botaoCancelar);

        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(e -> dispose());
        panelBotoes.add(botaoSair);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(panelBotoes, gbc);
    }

    private void incluirUsuario() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());
        String email = campoEmail.getText();
        String status = (String) comboStatus.getSelectedItem();
        // Aqui você pode adicionar a lógica para incluir o usuário
        JOptionPane.showMessageDialog(this, "Usuário incluído:\n" +
                "Usuário: " + usuario + "\n" +
                "Email: " + email + "\n" +
                "Status: " + status);
        limparCampos();
    }

    private void alterarUsuario() {
        String usuario = campoUsuario.getText();
        // Aqui você pode adicionar a lógica para alterar o usuário
        JOptionPane.showMessageDialog(this, "Usuário alterado:\n" +
                "Usuário: " + usuario);
        limparCampos();
    }

    private void excluirUsuario() {
        String usuario = campoUsuario.getText();
        // Aqui você pode adicionar a lógica para excluir o usuário
        JOptionPane.showMessageDialog(this, "Usuário excluído:\n" +
                "Usuário: " + usuario);
        limparCampos();
    }

    private void consultarUsuario() {
        String usuario = campoUsuario.getText();
        // Aqui você pode adicionar a lógica para consultar o usuário
        JOptionPane.showMessageDialog(this, "Consultando usuário:\n" +
                "Usuário: " + usuario);
        // Preencher os campos com os dados do usuário consultado (exemplo)
        campoEmail.setText("email@exemplo.com");
        campoSenha.setText("senha123");
        comboStatus.setSelectedItem("Ativo");
    }

    private void cancelarCadastro() {
        limparCampos();
    }

    private void limparCampos() {
        campoUsuario.setText("");
        campoSenha.setText("");
        campoEmail.setText("");
        comboStatus.setSelectedIndex(0);
    }
}
