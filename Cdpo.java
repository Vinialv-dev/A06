import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Cliente {
    private String nome;
    private Endereco endereco;
    private String sexo;
    private String telefone;
    private String email;
    private String nascimento;
    private boolean autorizado;

    public Cliente(String nome, Endereco endereco, String sexo, String telefone, String email, String nascimento, boolean autorizado) {
        this.nome = nome.toUpperCase(); // Nome em caixa alta
        this.endereco = endereco;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.autorizado = autorizado;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nascimento='" + nascimento + '\'' +
                ", autorizado=" + autorizado +
                '}';
    }
}


class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}


public class CadastroClientes {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Pesquisar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    pesquisarCliente();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }


    private static void incluirCliente() {
        System.out.print("Nome (6-60 caracteres): ");
        String nome = scanner.nextLine();
        while (!validarNome(nome)) {
            System.out.print("Nome inválido. Tente novamente: ");
            nome = scanner.nextLine();
        }

        System.out.print("Logradouro (até 60 caracteres): ");
        String logradouro = scanner.nextLine();
        while (!validarLogradouro(logradouro)) {
            System.out.print("Logradouro inválido. Tente novamente: ");
            logradouro = scanner.nextLine();
        }

        System.out.print("Número (até 4 dígitos): ");
        String numero = scanner.nextLine();
        while (!validarNumero(numero)) {
            System.out.print("Número inválido. Tente novamente: ");
            numero = scanner.nextLine();
        }

        System.out.print("Complemento (opcional, até 60 caracteres): ");
        String complemento = scanner.nextLine();

        System.out.print("Bairro (até 60 caracteres): ");
        String bairro = scanner.nextLine();
        while (!validarBairro(bairro)) {
            System.out.print("Bairro inválido. Tente novamente: ");
            bairro = scanner.nextLine();
        }

        System.out.print("Cidade (até 60 caracteres): ");
        String cidade = scanner.nextLine();
        while (!validarCidade(cidade)) {
            System.out.print("Cidade inválida. Tente novamente: ");
            cidade = scanner.nextLine();
        }

        System.out.print("CEP (formato 99999-999): ");
        String cep = scanner.nextLine();
        while (!validarCEP(cep)) {
            System.out.print("CEP inválido. Tente novamente: ");
            cep = scanner.nextLine();
        }

        System.out.print("Estado (2 caracteres): ");
        String estado = scanner.nextLine();
        while (!validarEstado(estado)) {
            System.out.print("Estado inválido. Tente novamente: ");
            estado = scanner.nextLine();
        }

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine().toUpperCase();
        while (!validarSexo(sexo)) {
            System.out.print("Sexo inválido. Tente novamente: ");
            sexo = scanner.nextLine().toUpperCase();
        }

        System.out.print("Telefone ((99) X9999-9999): ");
        String telefone = scanner.nextLine();
        while (!validarTelefone(telefone)) {
            System.out.print("Telefone inválido. Tente novamente: ");
            telefone = scanner.nextLine();
        }

        System.out.print("Email (opcional, até 80 caracteres): ");
        String email = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String nascimento = scanner.nextLine();
        while (!validarNascimento(nascimento)) {
            System.out.print("Data de Nascimento inválida. Tente novamente: ");
            nascimento = scanner.nextLine();
        }

        System.out.print("Autorizado (true/false): ");
        boolean autorizado = scanner.nextBoolean();

        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, cep, estado);
        Cliente cliente = new Cliente(nome, endereco, sexo, telefone, email, nascimento, autorizado);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }


    private static void alterarCliente() {
        System.out.print("Informe o nome do cliente a ser alterado: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                // Chame incluirCliente() ou faça alterações diretas nos campos do cliente
                System.out.println("Cliente encontrado: " + cliente);
                // Alterar informações se necessário
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private static void excluirCliente() {
        System.out.print("Informe o nome do cliente a ser excluído: ");
        String nome = scanner.nextLine();
        clientes.removeIf(cliente -> cliente.getNome().equalsIgnoreCase(nome));
        System.out.println("Cliente excluído com sucesso (se encontrado).");
    }


    private static void pesquisarCliente() {
        System.out.print("Informe o nome do cliente a ser pesquisado: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente encontrado: " + cliente);
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }


    private static boolean validarNome(String nome) {
        return nome.length() >= 6 && nome.length() <= 60 && nome.matches("[A-Za-zÀ-ÿ\\s]+");
    }


    private static boolean validarLogradouro(String logradouro) {
        return logradouro.length() <= 60 && logradouro.matches("[A-Za-z0-9À-ÿ\\s]+");
    }


    private static boolean validarNumero(String numero) {
        return numero.matches("\\d{1,4}");
    }


    private static boolean validarBairro(String bairro) {
        return bairro.length() <= 60 && bairro.matches("[A-Za-z0-9À-ÿ\\s]+");
    }

    private static boolean validarCidade(String cidade) {
        return cidade.length() <= 60 && cidade.matches("[A-Za-z0-9À-ÿ\\s]+");
    }


    private static boolean validarCEP(String cep) {
        return Pattern.matches("\\d{5}-\\d{3}", cep);
    }


    private static boolean validarEstado(String estado) {
        return estado.length() == 2 && estado.matches("[A-Za-z]{2}");
    }


    private static boolean validarSexo(String sexo) {
        return sexo.equals("M")
import java.util.Scanner;


public class SaudeUsuario {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Solicita ao usuário que insira seu nome
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        // Exibe uma saudação
        System.out.println("Olá, " + nome + "! Seja bem-vindo ao sistema.");
        
        // Fecha o scanner
        scanner.close();
    }
}