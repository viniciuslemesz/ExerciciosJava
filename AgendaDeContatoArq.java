import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AgendaDeContatoArq 
{

    private static final Path CAMINHO_ARQUIVO = Paths.get("agenda.txt");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            // menu principal
            System.out.println("\n-- agenda de contatos --\n");
            System.out.println("[1] adicionar contato");
            System.out.println("[2] editar contato");
            System.out.println("[3] excluir contato");
            System.out.println("[4] listar contatos");
            System.out.println("[5] sair");
            System.out.print("escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    // entrada do nome e telefone
                    System.out.print("digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    adicionarContato(nome, telefone);
                    break;
                case 2:
                    // listar antes de editar
                    listarContatos();
                    System.out.print("digite o numero do contato a ser editado: ");
                    int numEditar = scanner.nextInt();
                    scanner.nextLine(); // limpa o buffer
                    editarContato(numEditar);
                    break;
                case 3:
                    // listar antes de excluir
                    listarContatos();
                    System.out.print("digite o numero do contato a ser excluido: ");
                    int numExcluir = scanner.nextInt();
                    scanner.nextLine(); // limpa o buffer
                    excluirContato(numExcluir);
                    break;
                case 4:
                    // listar contatos
                    listarContatos();
                    break;
                case 5:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("opcao invalida!");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void adicionarContato(String nome, String telefone) {
        // monta a linha com nome e telefone separados por ;
        String linha = nome + ";" + telefone;

        try {
            // escreve no arquivo, criando ou adicionando no final
            Files.write(CAMINHO_ARQUIVO,
                    (linha + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("contato adicionado: " + nome);
        } catch (IOException e) {
            System.out.println("erro ao adicionar contato: " + e.getMessage());
        }
    }

    private static void editarContato(int numeroContato) {
        try {
            // verifica se o arquivo existe
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("arquivo ainda nao existe.");
                return;
            }

            // le todas as linhas do arquivo
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

            // verifica se o numero e valido
            if (numeroContato < 1 || numeroContato > linhas.size()) {
                System.out.println("numero de contato invalido.");
                return;
            }

            // pega o contato pelo indice
            String[] partes = linhas.get(numeroContato - 1).split(";");
            String nome = partes[0];

            // pede novo telefone
            System.out.print("digite o novo telefone para " + nome + ": ");
            String novoTelefone = scanner.nextLine();

            // atualiza a linha
            linhas.set(numeroContato - 1, nome + ";" + novoTelefone);

            // reescreve o arquivo com os dados atualizados
            Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("telefone de " + nome + " atualizado para " + novoTelefone);

        } catch (IOException e) {
            System.out.println("erro ao editar contato: " + e.getMessage());
        }
    }

    private static void excluirContato(int numeroContato) {
        try {
            // verifica se o arquivo existe
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("arquivo ainda nao existe.");
                return;
            }

            // le as linhas do arquivo
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

            // verifica se o numero e valido
            if (numeroContato < 1 || numeroContato > linhas.size()) {
                System.out.println("numero de contato invalido.");
                return;
            }

            // remove o contato pelo indice
            linhas.remove(numeroContato - 1);
            Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("contato removido com sucesso.");

        } catch (IOException e) {
            System.out.println("erro ao excluir contato: " + e.getMessage());
        }
    }

    private static void listarContatos() {
        if (!Files.exists(CAMINHO_ARQUIVO)) {
            System.out.println("arquivo ainda nao existe.");
            return;
        }

        try {
            // le todas as linhas do arquivo
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

            if (linhas.isEmpty()) {
                System.out.println("nenhum contato salvo.");
            } else {
                // ordena os contatos
                Collections.sort(linhas);

                // mostra o cabecalho da tabela
                System.out.println("\n-- listagem de contatos --\n");
                System.out.printf("%-4s %-20s %-15s\n", "n.", "nome", "telefone");

                // mostra cada contato com numero
                for (int i = 0; i < linhas.size(); i++) {
                    String[] partes = linhas.get(i).split(";");
                    System.out.printf("%-4d %-20s %-15s\n", i + 1, partes[0], partes[1]);
                }

                // atualiza o arquivo com os dados ordenados
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println("erro ao ler contatos: " + e.getMessage());
        }
    }
}
