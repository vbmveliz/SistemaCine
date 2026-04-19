package ui;

import modelos.Pelicula;
import procesos.CineService;

public class Main {
    public static void main(String[] args) {

        // ------------ PELÍCULAS ----------
        CineService cine = new CineService();

        cine.registrarPelicula(new Pelicula(1, "Avengers", 120));
        cine.registrarPelicula(new Pelicula(2, "Batman", 110));

        cine.listarPeliculas();
        

       }
}