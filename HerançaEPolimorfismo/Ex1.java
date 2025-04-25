import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        Animal meuGato = new Animal("Bu", 11);
        meuGato.mostrarInformacoes();
        meuGato.emitirSom();
        System.out.println();
        
        Cachorro meuCachorro = new Cachorro("Bob", 5, "Labrador");
        meuCachorro.mostrarInformacoes();
        meuCachorro.emitirSom();
        
    }
}

class Animal
{
    
    private String nome;
    private int idade;
    
    public Animal(String nome, int idade)
    {
     this.nome = nome;
     this.idade = idade;    
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public int getIdade()
    {
        return idade;
    }
    
    public void emitirSom()
    {
        System.out.printf("\nSom generico de animal.");
    }

    public void mostrarInformacoes()
    {
        System.out.println("Nome: " + getNome());
        System.out.println("\nIdade: " + getIdade());
        
    }
    
}

class Cachorro extends Animal
{
    private String raca;
    
        public Cachorro(String nome, int idade, String raca)   
        {
            super(nome, idade);
            this.raca = raca;
        }

    public String getRaca()
    {
        return raca;
    }

    @Override
     public void emitirSom()
    {
        System.out.printf("\nAu au");
    }

    @Override
    public void mostrarInformacoes()
    {
        super.mostrarInformacoes();
        System.out.println("\nRaca: " + getRaca());
    }
}
