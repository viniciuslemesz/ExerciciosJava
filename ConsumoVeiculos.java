// javac ConsumoVeiculos.java
// java ConsumoVeiculos

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ConsumoVeiculos {

    private static final Path CAMINHO_ARQUIVO = Paths.get("carros.txt");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        System.out.println("---CONSUMO DE VEICULOS---");
        System.out.printf("Digite para selecionar:\n(1)Add Carro\n(2)Verificar Lista Consumo\n");
        opcao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        switch (opcao) {
            case 1:
                // entrada dos dados
                System.out.print("digite o fabricante do carro: ");
                String fabricante = scanner.nextLine();

                System.out.print("digite o modelo do carro: ");
                String modelo = scanner.nextLine();

                System.out.print("digite o consumo medio do carro: ");
                double consumo_medio = scanner.nextDouble();
                scanner.nextLine(); // limpar buffer novamente

                Carro carro = new Carro(fabricante, modelo, consumo_medio);

                verificarConsumo(carro);
                break;

            case 2:
                // você pode implementar aqui a lógica para ler e mostrar os carros do arquivo
                System.out.println("Opção de listar carros ainda não implementada.");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }

    private static void verificarConsumo(Carro carro) {
        String linha = carro.getFabricante() + ";" + carro.getModelo() + ";" + carro.getConsumo_medio();
    
        try {
            Files.write(CAMINHO_ARQUIVO,
                    (linha + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("Carro adicionado: " + linha);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar carro: " + e.getMessage());
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
