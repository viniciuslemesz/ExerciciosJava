import java.util.Scanner;

class AgendaDeContatos{
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);    
        
    
        Contato[] contato = new Contato[2];
        
        
        int numContato = 0;
        int escolher = 0;
        do{
        System.out.println("---AGENDA DE CONTATOS---");
        System.out.println("[1]Adicionar contato.\n[2]Buscar contato.");
        
        escolher = input.nextInt();
        input.nextLine();
        
            
        switch(escolher){
            case 1:
                System.out.print("Adicionar nome do contato: ");
                String nome = input.nextLine();
                
                System.out.printf("Adicionar numero do contato: ");
                String tel = input.nextLine();
                
                System.out.println("Contato cadastrado com sucesso!\n//----------//");
                numContato++;
                break;
        case 2:
            System.out.printf("Nome do contato que deseja buscar: ");
            String procurar = input.nextLine();
            if(procurar == nome){
                System.out.println("Contato: " + nome + "\n//----------//");
            }
            
        }
        }while(escolher != 6);
    }
}

class Contato{
    String nome;
    String tel;
    
    public void Contato(String nome){
        this.nome = nome;
        this.tel = tel;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(String nome){
        return nome;
    }
    
    //-----------------------------------------//
    //telefone
    
    public void setTel(String nome){
        this.tel = tel;
    }
    
    public String getTel(){
        return tel;
    }
    
    
    public void exibir(){
        System.out.println("NOME: " + this.nome);
        System.out.println("TELEFONE: " + this.tel);
    }
}