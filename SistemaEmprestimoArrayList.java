import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);   
        
        List<Cliente> cliente = new ArrayList<>();
        List<Livro> livro = new ArrayList<>();
        List<Emprestimo> emprestimo = new ArrayList<>();
     
    int i = 0;  
        
    do{
    
      
    System.out.printf("/---Emprestimo de Livros---/\n");    
    System.out.printf("Nome do cliente: ");
    String nome = input.nextLine();
    
    System.out.printf("Idade do cliente: ");
    int idade = input.nextInt();
    
    cliente.add(new Cliente(nome, idade));
    
    input.nextLine();
    
    System.out.printf("Livro: ");
    String nomelivro = input.nextLine();
    
    System.out.printf("Autor: ");
    String autorlivro = input.nextLine();
    
    livro.add(new Livro(nomelivro, autorlivro));

    System.out.printf("Data do emprestimo(ex:10/02/2025): ");
    String data = input.nextLine();
    
    emprestimo.add(new Emprestimo(data, cliente.get(i), livro.get(i)));
    
    i++;
    }while(i<2);    
    
        for(Emprestimo elemento : emprestimo){
                        elemento.Exibirdetalhes();
                    }
    
    }
}

class Cliente
{
    private String nome;
    private int idade;
    
    public Cliente(String nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }
    
    public void setNome(String nome)
    {
       this.nome = nome;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public int getIdade()
    {
        return this.idade;
    }
}

class Livro
{
    private String titulo;
    private String autor;
    
    public Livro(String titulo, String autor)
    {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor)
    {
        this.autor = autor;
    }
    
    public String getTitulo()
    {
        return this.titulo;
    }
    
    public String getAutor()
    {
        return this.autor;
    }
}

class Emprestimo
{
    private String data;
    private Cliente cliente;
    private Livro livro;
    
    public Emprestimo(String data, Cliente cliente, Livro livro)
    {
     this.data = data;
     this.cliente = cliente;
     this.livro = livro;
    }
    
    public String getData()
    {
        return this.data;
    }
    public void Exibirdetalhes()
    {
        System.out.println("\n/---Dados do emprestimo---/");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Idade do cliente: " + cliente.getIdade());
        System.out.println("Livro: " + livro.getTitulo() + " do autor " + livro.getAutor());
        System.out.println("Data do emprestimo: " + getData());
    }
    
}