import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.Duration;

public class Estacionamento
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int i = 0;
        List<Placa> placa = new ArrayList<>();
        List<Horario> horarios = new ArrayList<>();
        List<Recibo> recibos = new ArrayList<>();
    
        do{
            System.out.println("---Entrada de Informacoes---");
            System.out.print("Placa do Carro: ");
            String numeracao = input.nextLine();
            
            System.out.print("Informe o horario de entrada (hh:mm): ");
            String horarioInicialString = input.nextLine();
            
            System.out.print("Informe o horario de saida (hh:mm): ");
            String horarioFinalString = input.nextLine();
        
            
            placa.add(new Placa(numeracao));
        
            // add o Horario diretamente
            Horario h = new Horario();
            h.setHorarioEntrada(horarioInicialString);
            h.setHorarioSaida(horarioFinalString);
            horarios.add(h); //guarda horario

            // objetos já armazenados na lista
            Recibo recibo = new Recibo("Recibo 01", placa.get(i), 
            horarios.get(i), horarios.get(i));
            recibos.add(recibo);

            i++;   
        } while(i < 1);    
    
        // exibir os recibos
        for(Recibo elemento : recibos){
            elemento.exibirRecibo();
        }
    }
}

class Placa
{
    String placa;
    
    public Placa(String placa)
    {
        this.placa = placa;
    }
    
    public String getPlaca()
    {
        return this.placa;
    }
}

class Horario
{
    String horarioEntrada;
    String horarioSaida;
    
    public void setHorarioEntrada(String horarioEntrada)
    {
        this.horarioEntrada = horarioEntrada;
    }
    
    public String getHorarioEntrada()
    {
        return this.horarioEntrada;
    }

    public void setHorarioSaida(String horarioSaida)
    {
        this.horarioSaida = horarioSaida;
    }
    
    public String getHorarioSaida()
    {
        return this.horarioSaida;
    }
}

class Recibo
{
    String recibo;
    Placa placa;
    Horario horarioEntrada;
    Horario horarioSaida;
    
    public Recibo(String recibo, Placa placa, Horario horarioEntrada, Horario horarioSaida)
    {
        this.recibo = recibo;
        this.placa = placa;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public void exibirRecibo()
    {
        double valor = 5.0;
        
        
        System.out.println("\n---RECIBO---");
        System.out.println("Placa do Carro: " + placa.getPlaca());
        System.out.println("Horario Entrada: " + horarioEntrada.getHorarioEntrada());
        System.out.println("Horario Saida: " + horarioSaida.getHorarioSaida());
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horarioInicial = LocalTime.parse(horarioEntrada.getHorarioEntrada(), formato);
        LocalTime horarioFinal = LocalTime.parse(horarioSaida.getHorarioSaida(), formato);

        Duration diferenca = Duration.between(horarioInicial, horarioFinal);
        long minutos = diferenca.toMinutes();
        
        if(minutos > 60.0 )
        {
            
                
                if(minutos % 15.0 == 0)
                {
                    double minutos_teste = minutos - 60.0;
            
                
                valor += Math.ceil(minutos_teste / 15.0) * 2.0; 
                /* A função ceil faz o arredondamento para cima */
                }
                
        }
        
        
        
        System.out.println("Duracao do estacionamento: " + minutos + " minutos");
        System.out.println("Valor cobrado: R$" + valor);
    }
}
