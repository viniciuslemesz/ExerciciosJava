class Exercicio{
    public static void main(String[] args){
        
        Produto p1 = new Produto("Panela");
        p1.preco = 79.99;
        p1.qntd_estoque = 20;    

        p1.exibir();
        
        p1.setPreco(25.99);
        p1.exibir();
    }
    
}

//    GETTER E SETTERS
class Produto{
    String nome; 
    double preco; 
    int qntd_estoque;
    
    public Produto(String nome){
        this.nome = nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    //--------------------------------------//
    
    public Produto(double preco){
        this.preco = preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public double getPreco(){
        return preco;
    }
    
    //-------------------------------------//

    public Produto(int qntd_estoque){
        this.qntd_estoque = qntd_estoque;
    }
    
    public void setQntd_estoque(int qntd_estoque){
        this.qntd_estoque = qntd_estoque;
    }
    
    public int getQntd_estoque(){
        return qntd_estoque;
    }
    
    public void exibir(){
        System.out.println("/-----------------/");
        System.out.println("Nome do produto: " + nome);
        System.out.println("Valor produto: " + preco);
        System.out.println("Estoque produto " + qntd_estoque);
    }
    
}