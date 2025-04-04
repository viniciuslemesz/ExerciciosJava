import java.util.ArrayList;
import java.util.Scanner;

public class AgendaDeContatos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Usando ArrayList para armazenar contatos
        ArrayList<Contato> contatos = new ArrayList<>();
        
        String nome = null;
        String tel = null;

        int numContato = 0;
        int escolher = 0;

        do {
            System.out.println("\n---AGENDA DE CONTATOS---");
            System.out.println("[1] Adicionar contato.");
            System.out.println("[2] Buscar contato.");
            System.out.println("[3] Editar contato.");
            System.out.println("[4] Excluir contato.");
            System.out.println("[5] Listar contatos.");
            System.out.println("[6] Sair.");
            
            escolher = input.nextInt();
            input.nextLine(); // Consumir o caractere de nova linha

            switch (escolher) {

            case 1:
                    // Adicionar novo contato
                    System.out.print("Adicionar nome do contato: ");
                    nome = input.nextLine();

                    System.out.printf("Adicionar numero do contato: ");
                    tel = input.nextLine();

                    System.out.println("Contato cadastrado com sucesso!\n//----------//");

                    contatos.add(new Contato(nome, tel)); // Adiciona o novo contato na lista
                    numContato++;
                    break;

            case 2:
                    // Buscar contato
                    System.out.printf("Nome do contato que deseja buscar: ");
                    String procurar = input.nextLine();
                    boolean encontrado = false; // Variável para verificar se encontrou o contato

                    for (Contato contato : contatos) {
                        if (procurar.equalsIgnoreCase(contato.getNome())) {
                            System.out.println("Contato: " + contato.getNome() + "\nNumero: " + contato.getTel() + "\n//----------//");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Contato não encontrado!\n//----------//");
                    }
                    break;

            case 3:
                    // Editar contato
                    System.out.printf("Nome do contato que deseja editar: ");
                    procurar = input.nextLine();

                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(procurar)) {
                            // Encontrou o contato, agora faz a edição
                            System.out.print("Editar nome do contato: ");
                            contato.setNome(input.nextLine());

                            System.out.printf("Editar numero do contato: ");
                            contato.setTel(input.nextLine());

                            System.out.println("Contato editado com sucesso!\n//----------//");
                            break;
                        }
                    }
                    break;

            case 4:
                    // Excluir contato
                    System.out.printf("Digite o contato que deseja excluir: ");
                    procurar = input.nextLine();

                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(procurar)) {
                            contatos.remove(contato);
                            System.out.println("Contato excluído com sucesso!\n//----------//");
                            break;
                        }
                    }
                    break;

            case 5:
                    // Listar contatos
                    System.out.println("Lista de contatos:");
                    for (Contato contato : contatos) {
                        System.out.println("Nome: " + contato.getNome() + "\nNumero de contato: " + contato.getTel());
                        System.out.println("\n//----------//");
                    }
                    break;

            }

        } while (escolher != 6);

        input.close();
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
