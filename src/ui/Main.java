package ui;
import modelos.Funcion;
import modelos.Pelicula;
import procesos.CineService;

public class Main {
    public static void main(String[] args) {

        // ------------ PELÍCULAS ----------
        CineService cine = new CineService();

        cine.registrarPelicula(new Pelicula(1, "Avengers", 120));
        cine.registrarPelicula(new Pelicula(2, "Batman", 110));

        cine.listarPeliculas();
        
     // ------------ FUNCIONES ----------
        cine.registrarFuncion(
            new Funcion(1, "8:00 PM", "10:00 PM",
            new Pelicula(1, "Avengers", 120))
        );

        cine.registrarFuncion(
            new Funcion(2, "10:30 PM", "12:20 AM",
            new Pelicula(2, "Batman", 110))
        );

        cine.listarFunciones();

            }
}