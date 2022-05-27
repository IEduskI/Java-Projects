package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

        int opcion = -1;
        Scanner cons = new Scanner(System.in);

        while (opcion != 0) {
            System.out.println("1. Iniciar catalogo de peliculas");
            System.out.println("2. Agregar pelicula");
            System.out.println("3. Listar peliculas");
            System.out.println("4. Buscar pelicula");
            System.out.println("0. Salir");

            System.out.print("Escoja: ");
            opcion = Integer.parseInt(cons.nextLine());

            System.out.println("");

            menu(opcion, catalogoPeliculas, cons);
            System.out.println("=====================");
            System.out.println("");
        }
    }

    public static void menu(int opcion, CatalogoPeliculas catalogoPeliculas, Scanner cons) {
        switch (opcion) {
            case 1:
                catalogoPeliculas.iniciarArchivo();
                break;
            case 2:
                System.out.print("Introduce el nombre de la pelicula: ");
                String pelicula = cons.nextLine();
                catalogoPeliculas.agregarPelicula(pelicula);
                break;
            case 3:
                catalogoPeliculas.listarPeliculas();
                break;
            case 4:
                System.out.print("Introduce el nombre de la pelicula: ");
                String buscarPelicula = cons.nextLine();
                catalogoPeliculas.buscarPelicula(buscarPelicula);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
