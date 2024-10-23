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
        menuPessoas.addActionListener(e -> new JanelaCadastroPessoa().setVisible(true));
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
        setSize(350, 250);
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
        JOptionPane.showMessageDialog(this, "Usuário incluído:\n" +
                "Usuário: " + usuario + "\n" +
                "Email: " + email + "\n" +
                "Status: " + status);
        limparCampos();
    }

    private void alterarUsuario() {
        String usuario = campoUsuario.getText();
        JOptionPane.showMessageDialog(this, "Usuário alterado:\n" +
                "Usuário: " + usuario);
        limparCampos();
    }

    private void excluirUsuario() {
        String usuario = campoUsuario.getText();
        JOptionPane.showMessageDialog(this, "Usuário excluído:\n" +
                "Usuário: " + usuario);
        limparCampos();
    }

    private void consultarUsuario() {
        String usuario = campoUsuario.getText();
        JOptionPane.showMessageDialog(this, "Consultando usuário:\n" +
                "Usuário: " + usuario);
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

class JanelaCadastroPessoa extends JFrame {
    private JTextField campoNome;
    private JTextField campoEndereco;
    private JTextField campoCidade;
    private JTextField campoUF;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JComboBox<String> comboSexo;

    public JanelaCadastroPessoa() {
        setTitle("Cadastro de Pessoa");
        setSize(400, 350);
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
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        campoNome = new JTextField();
        add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Endereço:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        campoEndereco = new JTextField();
        add(campoEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Cidade:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        campoCidade = new JTextField();
        add(campoCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("UF:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        campoUF = new JTextField();
        add(campoUF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        campoEmail = new JTextField();
        add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        campoTelefone = new JTextField();
        add(campoTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        String[] sexoOptions = {"Masculino", "Feminino"};
        comboSexo = new JComboBox<>(sexoOptions);
        add(comboSexo, gbc);

        // Botões de ação
        JPanel panelBotoes = new JPanel();
        JButton botaoIncluir = new JButton("Incluir");
        botaoIncluir.addActionListener(e -> incluirPessoa());
        panelBotoes.add(botaoIncluir);

        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.addActionListener(e -> alterarPessoa());
        panelBotoes.add(botaoAlterar);

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(e -> excluirPessoa());
        panelBotoes.add(botaoExcluir);

        JButton botaoConsultar = new JButton("Consultar");
        botaoConsultar.addActionListener(e -> consultarPessoa());
        panelBotoes.add(botaoConsultar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> cancelarCadastro());
        panelBotoes.add(botaoCancelar);

        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(e -> dispose());
        panelBotoes.add(botaoSair);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(panelBotoes, gbc);
    }

    private void incluirPessoa() {
        String nome = campoNome.getText();
        String endereco = campoEndereco.getText();
        String cidade = campoCidade.getText();
        String uf = campoUF.getText();
        String email = campoEmail.getText();
        String telefone = campoTelefone.getText();
        String sexo = (String) comboSexo.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Pessoa incluída:\n" +
                "Nome: " + nome + "\n" +
                "Endereço: " + endereco + "\n" +
                "Cidade: " + cidade + "\n" +
                "UF: " + uf + "\n" +
                "Email: " + email + "\n" +
                "Telefone: " + telefone + "\n" +
                "Sexo: " + sexo);
        limparCampos();
    }

    private void alterarPessoa() {
        String nome = campoNome.getText();
        JOptionPane.showMessageDialog(this, "Pessoa alterada:\n" +
                "Nome: " + nome);
        limparCampos();
    }

    private void excluirPessoa() {
        String nome = campoNome.getText();
        JOptionPane.showMessageDialog(this, "Pessoa excluída:\n" +
                "Nome: " + nome);
        limparCampos();
    }

    private void consultarPessoa() {
        String nome = campoNome.getText();
        JOptionPane.showMessageDialog(this, "Consultando pessoa:\n" +
                "Nome: " + nome);
        // Preencher os campos com os dados da pessoa consultada (exemplo)
        campoEndereco.setText("Rua Exemplo, 123");
        campoCidade.setText("Cidade Exemplo");
        campoUF.setText("UF");
        campoEmail.setText("email@exemplo.com");
        campoTelefone.setText("123456789");
        comboSexo.setSelectedItem("Masculino");
    }

    private void cancelarCadastro() {
        limparCampos();
    }

    private void limparCampos() {
        campoNome.setText("");
        campoEndereco.setText("");
        campoCidade.setText("");
        campoUF.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");
        comboSexo.setSelectedIndex(0);
    }
}
