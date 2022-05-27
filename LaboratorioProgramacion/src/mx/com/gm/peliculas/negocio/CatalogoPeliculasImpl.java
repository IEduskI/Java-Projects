package mx.com.gm.peliculas.negocio;

//import java.util.List;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(new Pelicula(nombrePelicula), NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = datos.listar(NOMBRE_ARCHIVO);

            peliculas.forEach(pelicula -> {
                System.out.println(pelicula.getNombre());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        try {
            var pelicula = datos.buscar(NOMBRE_ARCHIVO, buscar);
            System.out.println(pelicula);

        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                this.datos.borrar(NOMBRE_ARCHIVO);
                this.datos.crear(NOMBRE_ARCHIVO);
            } else {
                this.datos.crear(NOMBRE_ARCHIVO);
            }

        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }
}
