public class ExItemBiblioteca {
    
    public static void main(String[] args)
    {
        Livro livro = new Livro("Machado de assis", 60, "Dom Casmurro", 1970);
        livro.mostrarInfo();

        //Cd cd = new Cd("Ficcao Cientifica", 136, "Matrix", 1999);
        
        DVD dvd = new DVD("Ficcao Cientifica", 136, "Matrix", 1999);   
        dvd.mostrarInfo();

    }

}

class ItemBiblioteca
{

    private String titulo;
    private int anoPub;


    public ItemBiblioteca(String titulo, int anoPub)
    {
        this.titulo = titulo;
        this.anoPub = anoPub;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public void mostrarInfo()
    {
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Ano Publicacao: " + getAnoPub());
    }

}

class Livro extends ItemBiblioteca
{

   private String autor;
   private int pag;

    public Livro(String autor, int pag, String titulo, int anoPub) {
        super(titulo, anoPub);
        this.autor = autor;
        this.pag = pag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    @Override
    public void mostrarInfo()
    {
        super.mostrarInfo();
        System.out.println("Autor: " + getAutor());
        System.out.println("Numero de paginas: " + getPag());
    }

    
    
}

class DVD extends ItemBiblioteca
{

   String categoria;
   int minutos;

    public DVD(String categoria, int minutos, String titulo, int anoPub) {
        super(titulo, anoPub);
        this.categoria = categoria;
        this.minutos = minutos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
@Override
public void mostrarInfo()
{
    super.mostrarInfo();
    System.out.println("Autor: " + getCategoria());
    System.out.println("Numero de paginas: " + getMinutos());
}
   
}