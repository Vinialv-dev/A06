import java.util.Scanner;

public class cardapio {
    static String[] produtos = new String[10]; // Vetor para armazenar produtos
    static double[] precos = new double[10];   // Vetor para armazenar preços
    static String[] clientes = new String[10];  // Vetor para armazenar clientes
    static int contadorProdutos = 0; // Contador para produtos
    static int contadorClientes = 0;  // Contador para clientes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Consultar cardápio");
            System.out.println("3. Cadastrar cliente");
            System.out.println("4. Consultar clientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    consultarCardapio();
                    break;
                case 3:
                    cadastrarCliente(scanner);
                    break;
                case 4:
                    consultarClientes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    public static void cadastrarProduto(Scanner scanner) {
        if (contadorProdutos < produtos.length) {
            System.out.print("Digite o nome do produto: ");
            produtos[contadorProdutos] = scanner.nextLine();
            System.out.print("Digite o preço do produto: ");
            precos[contadorProdutos] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer
            contadorProdutos++;
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Limite de produtos atingido.");
        }
    }

    public static void consultarCardapio() {
        System.out.println("Cardápio:");
        for (int i = 0; i < contadorProdutos; i++) {
            System.out.println(produtos[i] + " - R$ " + precos[i]);
        }
    }

    public static void cadastrarCliente(Scanner scanner) {
        if (contadorClientes < clientes.length) {
            System.out.print("Digite o nome do cliente: ");
            clientes[contadorClientes] = scanner.nextLine();
            contadorClientes++;
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Limite de clientes atingido.");
        }
    }

    public static void consultarClientes() {
        System.out.println("Clientes cadastrados:");
        for (int i = 0; i < contadorClientes; i++) {
            System.out.println(clientes[i]);
        }
    }
}