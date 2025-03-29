import java.util.Scanner;

class AgendaDeContatos {
 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);

  Contato[] contato = new Contato[10];

  String nome = null;
  String tel = null;

  int numContato = 0;
  int escolher = 0;

  do {
   System.out.println("---AGENDA DE CONTATOS---");
   System.out.println("[1]Adicionar contato.\n[2]Buscar contato.\n[3]Editar contato.\n[4]Excluir contato.\n[5]Listar contatos.\n[6]Sair.");

   escolher = input.nextInt();
   input.nextLine();

   switch (escolher) {

    case 1:
     System.out.print("Adicionar nome do contato: ");
     nome = input.nextLine();

     System.out.printf("Adicionar numero do contato: ");
     tel = input.nextLine();

     System.out.println("Contato cadastrado com sucesso!\n//----------//");

     contato[numContato] = new Contato(nome, tel);
     numContato++;
     break;

    case 2:
     System.out.printf("Nome do contato que deseja buscar: ");
     String procurar = input.nextLine();
     boolean encontrado = false; // Variável para verificar se encontrou o contato

     for (int i = 0; i < numContato; i++) {
      if (procurar.equalsIgnoreCase(contato[i].getNome())) {
       System.out.println("Contato: " + contato[i].getNome() + "\nNumero: " + contato[i].getTel() + "\n//----------//");
       encontrado = true; // Contato encontrado
       break;
      }
     }

     if (!encontrado) {
      System.out.println("Contato não encontrado!\n//----------//");
     }
     break;

    case 3:
     System.out.printf("Nome do contato que deseja editar: ");
     procurar = input.nextLine();

     for (int i = 0; i < numContato; i++) {
      if (contato[i].getNome().equalsIgnoreCase(procurar)) {
       // Encontrou o contato, agora faz a edição
       System.out.print("Editar nome do contato: ");
       contato[i].setNome(input.nextLine());

       System.out.printf("Editar numero do contato: ");
       contato[i].setTel(input.nextLine());

       System.out.println("Contato editado com sucesso!\n//----------//");
       break;
      }
     }
     break;

    case 4:
     System.out.printf("Digite o contato que deseja excluir: ");
     procurar = input.nextLine();

     for (int i = 0; i < numContato; i++) {
      if (contato[i].getNome().equalsIgnoreCase(procurar)) {
       contato[i].setNome(null);
       contato[i].setTel(null);

       System.out.println("Contato excluído com sucesso!\n//----------//");
      }
     }
     break;
     
     case 5:
        System.out.printf("Lista de contatos:\n");
        for(int i=0;i<numContato;i++){
            System.out.println("Nome: " + contato[i].getNome() + "\nNumero de contato: " + contato[i].getTel());
            System.out.println("\n//----------//");
        }
        
   }

  } while (escolher != 6);
 }
}

class Contato {
 String nome;
 String tel;

 public Contato(String nome, String tel) {
  this.nome = nome;
  this.tel = tel;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getNome() {
  return nome;
 }

 public void setTel(String tel) {
  this.tel = tel;
 }

 public String getTel() {
  return tel;
 }

}
