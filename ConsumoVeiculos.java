// javac ConsumoVeiculos.java
// java ConsumoVeiculos

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class ConsumoVeiculos {

    private static final Path CAMINHO_ARQUIVO = Paths.get("carros.txt");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;  // declarar fora do loop para poder usar no while

        do {
            System.out.println("--- consumo de veiculos ---");
            System.out.println("digite para selecionar:");
            System.out.println("(1) adicionar carro");
            System.out.println("(2) gerar relatorio de consumo");
            System.out.println("(3) sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;

                case 2:
                    gerarRelatorio();
                    break;

                case 3:
                    System.out.println("saindo...");
                    break;

                default:
                    System.out.println("opcao invalida");
                    break;
            }

        } while (opcao != 3);

        scanner.close();  // fechar scanner somente aqui, depois que sair do loop
    }

    private static void adicionarCarro() {
        System.out.print("digite o fabricante do carro: ");
        String fabricante = scanner.nextLine();

        System.out.print("digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("digite o consumo medio do carro (km por litro): ");
        double consumoMedio = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer

        String linha = fabricante + ";" + modelo + ";" + consumoMedio;

        try {
            Files.write(CAMINHO_ARQUIVO,
                    (linha + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.out.println("carro adicionado com sucesso: " + linha);
        } catch (IOException e) {
            System.out.println("erro ao adicionar carro: " + e.getMessage());
        }
    }

    private static void gerarRelatorio() {
        try {
            System.out.print("digite o preco do combustivel (por litro): R$ ");
            double precoCombustivel = scanner.nextDouble();
            scanner.nextLine();

            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            StringBuilder relatorio = new StringBuilder();

            for (String linha : linhas) {
                String[] partes = linha.split(";");
                String fabricante = partes[0];
                String modelo = partes[1];
                double consumo = Double.parseDouble(partes[2]);

                double litros = 1000 / consumo;
                double custo = litros * precoCombustivel;

                String resultado = String.format("%s;%s;%.2f litros;R$ %.2f",
                        fabricante, modelo, litros, custo);

                relatorio.append(resultado).append(System.lineSeparator());
            }

            Path caminhoRelatorio = Paths.get("relatorio.txt");
            Files.write(caminhoRelatorio,
                    relatorio.toString().getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("relatorio gerado com sucesso: relatorio.txt");

        } catch (IOException e) {
            System.out.println("erro ao gerar relatorio: " + e.getMessage());
        }
    }
}

class Carro {
    private String fabricante;
    private String modelo;
    private double consumo_medio;

    public Carro(String fabricante, String modelo, double consumo_medio) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.consumo_medio = consumo_medio;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getConsumo_medio() {
        return consumo_medio;
    }

    public void setConsumo_medio(double consumo_medio) {
        this.consumo_medio = consumo_medio;
    }
}
