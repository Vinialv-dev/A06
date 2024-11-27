import javax.swing.*;
import java.awt.*;

public class ListaUsuarios {
    private final JFrame principal;

    public ListaUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método original: Exibir lista de usuários padrão
    public void exibir() {
        criarDialog("Lista de Usuários", "Exemplo de lista de usuários...", new Dimension(750, 650));
    }

    // Sobrecarga 1: Exibir com título personalizado
    public void exibir(String titulo) {
        criarDialog(titulo, "Exemplo de lista de usuários...", new Dimension(750, 650));
    }

    // Sobrecarga 2: Exibir com título e conteúdo personalizados
    public void exibir(String titulo, String conteudo) {
        criarDialog(titulo, conteudo, new Dimension(750, 650));
    }

    // Sobrecarga 3: Exibir com título, conteúdo e tamanho da janela personalizados
    public void exibir(String titulo, String conteudo, Dimension tamanho) {
        criarDialog(titulo, conteudo, tamanho);
    }

    // Método auxiliar privado para criar e configurar o diálogo
    private void criarDialog(String titulo, String conteudo, Dimension tamanho) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(tamanho);
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
