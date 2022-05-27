package mx.com.gm.peliculas.negocio;

public interface CatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "c:\\CatalogoPeliculas\\peliculas.txt";

    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarArchivo();
}
