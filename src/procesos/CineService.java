package procesos;

import java.util.ArrayList;
import modelos.Funcion;
import modelos.Pelicula;

public class CineService {

    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    // LISTA DE FUNCIONES
    private ArrayList<Funcion> funciones = new ArrayList<>();

    public void registrarPelicula(Pelicula p) {
        peliculas.add(p);
    }

    public void listarPeliculas() {
        for (Pelicula p : peliculas) {
            System.out.println(p);
        }
    }
    // ------------ FUNCIONES ------------

    public void registrarFuncion(Funcion funcion) {
        funciones.add(funcion);
    }

    public void listarFunciones() {

        System.out.println("=== FUNCIONES ===");

        for (Funcion f : funciones) {
            System.out.println(f);
        }
    }
}
