package ui;

import modelos.Pelicula;
import procesos.CineService;

public class Main {
    public static void main(String[] args) {

        CineService cine = new CineService();

        cine.registrarPelicula(new Pelicula(1, "Avengers", 120));
        cine.registrarPelicula(new Pelicula(2, "Batman", 110));
        cine.registrarPelicula(new Pelicula(3, "Chucky", 130));
        cine.registrarPelicula(new Pelicula(3, "Spiderman", 115));
        cine.registrarPelicula(new Pelicula(4, "Iron Man", 130));
        cine.registrarPelicula(new Pelicula(5, "Thor", 125));
        cine.registrarPelicula(new Pelicula(6, "Hulk", 100));
        cine.registrarPelicula(new Pelicula(7, "Doctor Strange", 110));
        cine.registrarPelicula(new Pelicula(8, "Black Panther", 118));
        cine.registrarPelicula(new Pelicula(9, "Captain Marvel", 112));
        cine.registrarPelicula(new Pelicula(10, "Ant-Man", 105));
        cine.registrarPelicula(new Pelicula(11, "Guardians", 120));
        cine.registrarPelicula(new Pelicula(12, "Flash", 108));
        cine.registrarPelicula(new Pelicula(13, "Matrix", 130));
        cine.registrarPelicula(new Pelicula(99, "PRUEBA", 100));
        cine.registrarPelicula(new Pelicula(200, "STASH_TEST", 123));
        cine.registrarPelicula(new Pelicula(300, "TEST_STASH", 100));
        // cambio prueba stashsss
     // ERROR INTENCIONAL
        cine.registrarPelicula(new Pelicula(999, "ERROR_PELICULA", -100));
        
        cine.listarPeliculas();
    }
}