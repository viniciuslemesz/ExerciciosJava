import java.util.Map;
import java.util.TreeMap;
 
public class Main {
    public static void main(String[] args) {
        /* Criando um TreeMap */
        Map<String, Fruta> frutas = new TreeMap<>();
 
        /* Adiciona frutas e suas informações ao estoque */
        frutas.put("Maca", new Fruta("Maca", 50, 2.5));
        frutas.put("Banana", new Fruta("Banana", 100, 1.75));
        frutas.put("Laranja", new Fruta("Laranja", 75, 3.0));
        
        /* Mostra o tamanho do mapa */
        System.out.println("Tamanho do mapa: " + frutas.size());
        System.out.println();
        
        /* Mostra os elementos do mapa */
        System.out.println("Elementos do mapa:");
        for (Map.Entry<String, Fruta> fruta : frutas.entrySet()) {
            fruta.getValue().mostrarInformacoes();
        }
        
        /* Verifica se Laranja existe no mapa */
        if (frutas.containsKey("laranja")) {
            System.out.println("Laranja existe no mapa.");
        } else {
            System.out.println("Laranja nao existe no mapa.");
        }
        System.out.println();
        
        /* Verificando se Laranja existe no mapa, independente do formato em que a palavra foi escrita */
        boolean encontrado = false;
        for (String fruta : frutas.keySet()) {
            if (fruta.equalsIgnoreCase("laranja")) {
                encontrado = true;
                break;
            }
        }
 
        if (encontrado == true) {
            System.out.println("Laranja existe no mapa.");
        } else {
            System.out.println("Laranja nao existe no mapa.");
        }
        System.out.println();
        
        /* Remove um elemento do mapa */
        frutas.remove("Maca");
        System.out.println("Maca foi removida do mapa.");
        System.out.println();
        
        /* Mostra os elementos do mapa */
        System.out.println("Elementos do mapa:");
        for (Map.Entry<String, Fruta> fruta : frutas.entrySet()) {
            fruta.getValue().mostrarInformacoes();
        }
        
        /* Limpa o mapa */
        frutas.clear();
        
        /* Verifica se o mapa está vazio */
        if (frutas.isEmpty()) {
            System.out.println("O mapa esta vazio.");
        }
    }
}
 
class Fruta {
    private String nome;
    private int quantidade;
    private double preco;
 
    public Fruta(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
 
    /* Métodos setters e getters e setters */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
 
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
    public int getQuantidade() {
        return quantidade;
    }
 
    public void setPreco(double preco) {
        this.preco = preco;
    }
 
    public double getPreco() {
        return preco;
    }
 
    /* Método para mostrar informações da fruta */
    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preco: R$ " + preco);
        System.out.println();
    }
}