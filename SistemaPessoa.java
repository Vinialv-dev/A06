import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        // Configurações da janela principal
        setTitle("Sistema de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criando o menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem itemUsuarios = new JMenuItem("Usuários");
        JMenuItem itemPessoas = new JMenuItem("Pessoas");
        
        menuCadastro.add(itemUsuarios);
        menuCadastro.add(itemPessoas);
        menuBar.add(menuCadastro);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem itemListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemListaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);
        menuBar.add(menuVisualizacao);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem itemSair = new JMenuItem("Sair");
        menuSair.add(itemSair);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        // Informações do rodapé
        String usuario = "Nome do Usuário"; // Substitua pelo nome do usuário real
        String dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String rodapeText = String.format("Versão: 1.0 | Usuário: %s | Data: %s", usuario, dataHora);
        JLabel rodape = new JLabel(rodapeText, JLabel.CENTER);
        add(rodape, BorderLayout.SOUTH);

        // Adicionando ação ao menu Sair
        itemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adicionando ações aos outros itens (exemplo)
        itemUsuarios.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir cadastro de usuários"));
        itemPessoas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir cadastro de pessoas"));
        itemListaUsuarios.addActionListener(e -> JOptionPane.showMessageDialog(this, "Visualizar lista de usuários"));
        itemListaPessoas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Visualizar lista de pessoas"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaPessoa sistemaPessoa = new SistemaPessoa();
            sistemaPessoa.setVisible(true);
        });
    }
}