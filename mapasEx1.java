import java.util.Map;
import java.util.TreeMap;
 
public class Main {
    public static void main(String[] args) {
        
        /* Cria um mapa de frutas */
        Map<String, Integer> frutas = new TreeMap<>();
 
        /* Adiciona frutas e suas quantidades em estoque ao mapa */
        frutas.put("Maca", 50);
        frutas.put("Banana", 100);
        frutas.put("Laranja", 75);
        
        /* Mostra o tamanho do mapa */
        System.out.println("Tamanho do mapa: " + frutas.size());
        System.out.println();
        
        /* Mostra os elementos do mapa */
        System.out.println("Estoque de frutas:");
        for (Map.Entry<String, Integer> fruta : frutas.entrySet()) {
            System.out.println("Fruta: " + fruta.getKey() + " - Quantidade: " + fruta.getValue());
        }
        System.out.println();
        
        /* Verifica se 'Laranja' existe no mapa */
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
        
        /* Atualiza a quantidade de macas no estoque */
        frutas.put("Maca", 60);
 
        /* Mostra os elementos do mapa*/
        System.out.println("Estoque de frutas:");
        for (Map.Entry<String, Integer> fruta : frutas.entrySet()) {
            System.out.println("Fruta: " + fruta.getKey() + " - Quantidade: " + fruta.getValue());
        }
        System.out.println();
        
        /* Remove uma fruta do estoque */
        frutas.remove("Maca");
        
        /* Mostra os elementos do mapa*/
        System.out.println("Estoque de frutas:");
        for (Map.Entry<String, Integer> fruta : frutas.entrySet()) {
            System.out.println("Fruta: " + fruta.getKey() + " - Quantidade: " + fruta.getValue());
        }
        System.out.println();
 
        /* Limpa o mapa*/
        frutas.clear();
 
        /* Verifica se o mapa esta vazio */
        if(frutas.isEmpty()){
            System.out.println("O mapa esta vazio.");
        }
    }
}