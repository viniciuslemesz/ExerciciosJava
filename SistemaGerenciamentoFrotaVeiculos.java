// SistemaGerenciamentoFrotaVeiculos.java
import java.util.ArrayList;


public class SistemaGerenciamentoFrotaVeiculos {
    public static void main(String[] args) {
        
        ArrayList<Veiculo> frota = new ArrayList<>();
        
    
        Carro c1 = new Carro("Vw", "Gol", 2020, 20, 13.3);
        Moto m1 = new Moto("Honda", "CG", 2021, 10, 2);
        Carro c2 = new Carro("Fiat", "Uno", 2015, 30, 12.0);
        Moto m2 = new Moto("Yamaha", "Factor", 2020, 12, 35.0);
        Carro c3 = new Carro("Chevrolet", "Onix", 2022, 40, 14.5);
        Moto m3 = new Moto("Suzuki", "Intruder", 2018, 15, 28.0);

        frota.add(c1);
        frota.add(c2);
        frota.add(c3);
        frota.add(m1);
        frota.add(m2);
        frota.add(m3);

        System.out.printf("/---FROTA VEICULOS---/\n");
        
        for (Veiculo veiculo : frota) {
            veiculo.mostrarDetalhes();
            System.out.printf("\n");
        }
        
         System.out.printf("\n/---COMANDOS DOS VEICULOS---/\n\n");
        
        c1.mostrarDetalhes();
        c1.acelerar();
        c1.frear();
        c1.precisaAbastecimento();
        c1.realizarViagem(100);
        
        System.out.printf("\n");
        c1.mostrarDetalhes();
        
        System.out.printf("\n/-----------/\n");
        
        m1.mostrarDetalhes();
        m1.acelerar();
        m1.frear();
        m1.precisaAbastecimento();
        m1.realizarViagem(30);
        
        System.out.printf("\n");
        m1.mostrarDetalhes();
        
        frota.remove(c2);
        frota.remove(m3);
        System.out.printf("\n\n");
        
        System.out.printf("/---FROTA VEICULOS---/\n");
        
        for (Veiculo veiculo : frota) {
            veiculo.mostrarDetalhes();
            System.out.printf("\n");
        }
        
    }
}


class Veiculo
{
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double combustivel;
    private double consumoMedio;
    

    
    public Veiculo(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.combustivel = combustivel;
        this.consumoMedio = consumoMedio;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public double getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }
    public double getConsumoMedio() {
        return consumoMedio;
    }
    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public double calcularAutonomia()
    {
        double autonomia = getCombustivel() * getConsumoMedio();
        return autonomia;
    }

    public void precisaAbastecimento()
    {
        boolean abastecer = false;

        if(calcularAutonomia() < 30)
        {
            abastecer = true;
        }
            
        if(abastecer == true)
        {
        System.out.printf("Precisa de abastecimento: Sim\n");
        }   
        else
        {
        System.out.printf("Precisa de abastecimento: Nao\n");
        }

    }

    public void realizarViagem(double distancia)
    {
         double combustivelUsado = distancia / consumoMedio;
        
        
        if(distancia < calcularAutonomia())
        {
         setCombustivel(getCombustivel() - combustivelUsado);
            System.out.printf("Viagem realizada! Restaram %.2f litros de combustivel no veiculo!\n", getCombustivel());
          
        }
        
        
        else
        {
            System.out.println("Nao foi possivel realizar a viagem!");
        }
        
    }

    public void mostrarDetalhes()
    {
        System.out.println("Veiculo: " + getMarca() + " " + getModelo());
        System.out.println("Ano de fabricacao: " + getAnoFabricacao());
        System.out.println("Autonomia: " + calcularAutonomia() + "km");
    }

    public void acelerar() {
        System.out.println("O veiculo acelerando...");
    }

    public void frear() {
        System.out.println("O veiculo freando...");
    }

}

// herança
class Carro extends Veiculo
{

   
    public Carro(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
        
        super(marca, modelo, anoFabricacao, combustivel, consumoMedio);
    }

    @Override
    public void acelerar()
    {
        System.out.println("Carro acelerando...");
    }
    @Override
    public void frear()
    {
        System.out.println("Carro freando...");
    }    

}

class Moto extends Veiculo
{
    public Moto(String marca, String modelo, int anoFabricacao, double combustivel, double consumoMedio) {
        
        super(marca, modelo, anoFabricacao, combustivel, consumoMedio);
    }

    @Override
    public void acelerar()
    {
        System.out.println("Moto esta acelerando...");
    }
    @Override
    public void frear()
    {
        System.out.println("Moto esta freando...");
    }    

     
}



