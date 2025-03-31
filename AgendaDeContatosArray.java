import java.util.ArrayList;
import java.util.Scanner;

public class AgendaDeContatos{
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);   
        
    ArrayList<Contato> contato = new ArrayList<>();  
        
    int numContato = 0;    
    int escolher = 0;    
    String nome = null;
    String tel = null;
    
        
    do{    
        
    System.out.println("\n---AGENDA DE CONTATOS---\n[1]Cadastrar Contato.\n/--------------/");
    escolher = input.nextInt();    
    input.nextLine();    
        
    switch(escolher){
        
    case 1:
    System.out.printf("Cadastre o nome do contato: ");
    nome = input.nextLine();
    //contato.add(nome);
    System.out.printf("Cadastre o numero do contato: ");    
    tel = input.nextLine();  
    //contato.add(tel);   
    
    Contato novoContato = new Contato(nome, tel);   
    contato.add(novoContato);    
    
    System.out.printf("Contato cadastrado com sucesso!\n");
    
    break;
        
    //case 2:
   // System.out.printf("Nome do contato que deseja buscar: ");
    //String procurar = input.nextLine();
   // boolean encontrado;
    
   // if(procurar.equalsIgnoreCase(novoContato.getNome()))
   // {
   // System.out.println("Contato encontrado!\n//----------//");   
   // encontrado = true;    
   // }
    //else if(!encontrado)
   // {
   //     System.out.println("Contato não encontrado!\n//----------//");
  //  }    
        
        
    }    
      
    }while(escolher != 6);  
    
}
}

class Contato{
    
    String nome;
    String tel;
    
    public Contato(String nome, String tel){
        this.nome = nome;
        this.tel = tel;
    } 
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setTel(String tel){
        this.tel = tel;
    }
    
    public String getTel(){
        return tel;
    }
    
    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome + " - Quantidade: " + tel);
    }
}