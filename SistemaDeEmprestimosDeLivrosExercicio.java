import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Vinicius", 18);
        Livro livro1 = new Livro("Joao", "Conto de fadas");
        Emprestimo emprestimo = new Emprestimo("20/03/2025", cliente1, livro1);
        
        emprestimo.Exibirdetalhes();
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
        System.out.println("Dados do emprestimo:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Data do emprestimo: " + getData());
    }
}