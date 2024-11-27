import javax.swing.*;
import java.awt.*;

public class ListaPessoas {
    private final JFrame principal;

    public ListaPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método original para exibir a lista de pessoas
    public void exibir() {
        criarDialog("Lista de Pessoas", "Exemplo de lista de pessoas...");
    }

    // Sobrecarga do método exibir para aceitar um título personalizado
    public void exibir(String titulo) {
        criarDialog(titulo, "Exemplo de lista de pessoas...");
    }

    // Sobrecarga do método exibir para aceitar título e conteúdo personalizados
    public void exibir(String titulo, String conteudo) {
        criarDialog(titulo, conteudo);
    }

    // Sobrecarga do método exibir para aceitar título, conteúdo e tamanho da janela
    public void exibir(String titulo, String conteudo, Dimension dimensao) {
        criarDialog(titulo, conteudo, dimensao);
    }

    // Método privado auxiliar para criar o JDialog com opções personalizadas
    private void criarDialog(String titulo, String conteudo) {
        criarDialog(titulo, conteudo, new Dimension(750, 650));
    }

    private void criarDialog(String titulo, String conteudo, Dimension dimensao) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(dimensao);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea(conteudo), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
