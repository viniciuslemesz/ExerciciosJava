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
        List<Funcionario> funcionario = new ArrayList<>();
        List<Horario> horarios = new ArrayList<>();
        List<Holerite> lista = new ArrayList<>();
        
    
    
        do{
            System.out.println("---Entrada de Informacoes---");
            System.out.print("Nome do funcionario: ");
            String nome = input.nextLine();
            
            System.out.print("Informe o horario de entrada (hh:mm): ");
            String horarioInicialString = input.nextLine();
            
            System.out.print("Informe o horario de saida (hh:mm): ");
            String horarioFinalString = input.nextLine();
        
            // add na lista
            funcionario.add(new Funcionario(nome));
        
            // add o Horario diretamente
            Horario h = new Horario();
            h.setHorarioEntrada(horarioInicialString);
            h.setHorarioSaida(horarioFinalString);
            horarios.add(h);  // armazena horario

            // armazena tudo na em uma variavel
            Holerite hol = new Holerite("Holerite 001", funcionario.get(i), horarios.get(i), horarios.get(i));
            lista.add(hol); // array list para add a variavel com as informações

            i++;   
        } while(i < 1);    
    
        // Exibe informacoes
        for(Holerite elemento : lista){
            elemento.exibirInformacoes();
        }
    }
}    


class Funcionario
{
    String nome;
    
    public Funcionario(String nome)
    {
        this.nome = nome;
    }
    
    
    public String getNome()
    {
        return this.nome;
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

class Holerite//só pra dar um nome de exemplo
{
    String holerite;
    Funcionario nome;
    Horario horarioEntrada;
    Horario horarioSaida;
    
    public Holerite(String holerite, Funcionario nome, Horario horarioEntrada, Horario horarioSaida)
    {
        this.holerite = holerite;
        this.nome = nome;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }
    
    public void exibirInformacoes()
{
    double horaExtra = 0;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime horarioInicial = LocalTime.parse(horarioEntrada.getHorarioEntrada(), formato);
    LocalTime horarioFinal = LocalTime.parse(horarioSaida.getHorarioSaida(), formato);

    Duration diferenca = Duration.between(horarioInicial, horarioFinal);
    long minutos = diferenca.toMinutes();
    double horas = minutos / 60.0;

    if (horas > 8) {
        horaExtra = horas - 8;
    }

    System.out.println("\n---INFORMACOES---");
    System.out.println("Nome funcionario: " + nome.getNome());
    System.out.println("Horario Entrada: " + horarioEntrada.getHorarioEntrada());
    System.out.println("Horario Saida: " + horarioSaida.getHorarioSaida());
    System.out.printf("Total de horas trabalhadas: %.2f\n", horas);
    System.out.printf("Horas extra: %.0f hora extra\n", horaExtra);
}

}
