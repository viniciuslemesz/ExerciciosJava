// javac AtividadeConsumoDisco/ConsumoEspacoDisco.java
// java AtividadeConsumoDisco.ConsumoEspacoDisco
// consumo.txt tem que ficar na pasta onde roda o java (fora da AtividadeConsumoDisco)

package AtividadeConsumoDisco;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumoEspacoDisco {

    private static final Path CAMINHO_ARQUIVO = Paths.get("consumo.txt"); // caminho do arquivo consumo
    private static final Scanner scanner = new Scanner(System.in); // scanner pra ler do teclado

    public static void main(String[] args) {
        int opcao = 0; // variavel pra guardar a opcao do usuario

        do {
            System.out.println("/---CONSUMO ESPACO DO DISCO---/");
            System.out.println("(1) Verificar Consumo"); // opcao pra mostrar o consumo
            System.out.println("(2) Editar Lista"); // opcao pra adicionar ou atualizar usuario
            System.out.println("(3) Sair"); // sair do programa
            System.out.print("Escolhe ai: ");
            opcao = scanner.nextInt(); // le a opcao
            scanner.nextLine(); // limpar o enter que sobra

            switch (opcao) {
                case 1:
                    verificarConsumo(); // chama funcao pra mostrar consumo
                    break;

                case 2:
                    editarLista(); // chama funcao pra editar a lista
                    break;

                case 3:
                    System.out.println("saindo do programa..."); // mensagem de saida
                    break;

                default:
                    System.out.println("opcao invalida, tenta de novo."); // aviso pra opcao errada
                    break;
            }
        } while (opcao != 3); // repete ate escolher sair
    }

    private static void verificarConsumo() {
        try {
            // le todas as linhas do arquivo consumo.txt
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

            List<Usuario> usuarios = new ArrayList<>(); // lista pra guardar os usuarios
            long totalBytes = 0; // variavel pra soma total de bytes usados

            for (String linha : linhas) {
                String[] partes = linha.trim().split("\\s+"); // separa nome e bytes
                String usuario = partes[0]; // pega nome
                long bytes = Long.parseLong(partes[1]); // pega bytes
                usuarios.add(new Usuario(usuario, bytes)); // cria objeto usuario e adiciona na lista
                totalBytes += bytes; // soma bytes no total
            }

            // ordena a lista de usuarios pelo nome em ordem alfabetica
            usuarios.sort((u1, u2) -> u1.nome.compareToIgnoreCase(u2.nome));

            System.out.println("Nr.\tUsuario\t\tEspaco utilizado\t% de uso");
            System.out.println("--------------------------------------------------------");

            int nr = 1; // contador pra numero da linha
            for (Usuario u : usuarios) {
                double mb = u.bytes / (1024.0 * 1024.0); // converte bytes pra megabytes
                double perc = (u.bytes * 100.0) / totalBytes; // calcula percentual do total
                System.out.printf("%d\t%-10s\t%10.2f MB\t\t%6.2f\n", nr, u.nome, mb, perc); // mostra info formatada
                nr++; // incrementa contador
            }

            System.out.println("--------------------------------------------------------");

            double totalMB = totalBytes / (1024.0 * 1024.0); // converte total bytes pra MB
            double mediaMB = totalMB / usuarios.size(); // calcula media por usuario

            System.out.printf("Espaco total ocupado: %.2f MB\n", totalMB); // mostra total
            System.out.printf("Espaco medio ocupado: %.2f MB\n", mediaMB); // mostra media

        } catch (IOException e) {
            // caso erro ao ler arquivo mostra mensagem de erro
            System.out.println("erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static void editarLista() {
        try {
            // le as linhas atuais do arquivo
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            List<Usuario> usuarios = new ArrayList<>();

            // transforma cada linha em objeto Usuario
            for (String linha : linhas) {
                String[] partes = linha.trim().split("\\s+");
                String nome = partes[0];
                long bytes = Long.parseLong(partes[1]);
                usuarios.add(new Usuario(nome, bytes));
            }

            System.out.print("Digite o nome do usuario: ");
            String nomeNovo = scanner.nextLine().trim(); // le nome novo

            System.out.print("Digite o espaco utilizado em bytes: ");
            long bytesNovo = scanner.nextLong(); // le bytes novo
            scanner.nextLine(); // limpar enter que sobra

            boolean encontrou = false; // flag pra saber se usuario ja existe

            // procura usuario na lista pra atualizar se existir
            for (Usuario u : usuarios) {
                if (u.nome.equalsIgnoreCase(nomeNovo)) {
                    u.bytes = bytesNovo; // atualiza bytes
                    encontrou = true;
                    break;
                }
            }

            // se nao achou usuario, adiciona novo na lista
            if (!encontrou) {
                usuarios.add(new Usuario(nomeNovo, bytesNovo));
                System.out.println("usuario adicionado com sucesso!");
            } else {
                System.out.println("usuario existente atualizado com sucesso!");
            }

            // prepara linhas pra gravar de novo no arquivo
            List<String> linhasParaGravar = new ArrayList<>();
            for (Usuario u : usuarios) {
                linhasParaGravar.add(u.nome + " " + u.bytes);
            }

            Files.write(CAMINHO_ARQUIVO, linhasParaGravar); // grava tudo no arquivo

        } catch (IOException e) {
            System.out.println("erro ao editar o arquivo: " + e.getMessage());
        }
    }

    // classe que guarda nome e bytes do usuario
    private static class Usuario {
        String nome;
        long bytes;

        Usuario(String nome, long bytes) {
            this.nome = nome;
            this.bytes = bytes;
        }
    }
}
