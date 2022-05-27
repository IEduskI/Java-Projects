package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);

        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        List<Pelicula> peliculas = new ArrayList();
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                peliculas.add(new Pelicula(lectura));
                lectura = entrada.readLine(); //Salta la linea
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        if (anexar) {
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(pelicula.getNombre());
                salida.close();
                System.out.println("Se ha agregado la pelicula");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
                throw new EscrituraDatosEx("Escepcion al escribir peliculas: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new EscrituraDatosEx("Escepcion al escribir peliculas: " + ex.getMessage());
            }
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        String pelicula = "Pelicula no encontrada";

        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            int indice = 1;
            while (lectura != null) {
                if (buscar != null && buscar.equalsIgnoreCase(lectura)) {
                    pelicula = "Pelicula " + lectura + " encontrada en el indice " + indice;
                    break;
                }
                lectura = entrada.readLine();
                indice++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        }

        return pelicula;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear archivo: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        if (existe(nombreArchivo)) {
            File archivo = new File(nombreArchivo);
            archivo.delete();
        } else {
            System.out.println("El archivo no existe");
        }
    }

}
