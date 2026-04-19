package procesos;

import java.util.ArrayList;
import modelos.Pelicula;

public class CineService {

    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    
    //METODOS CAMELCASE
    
    // Añadir pelicula 
    public void registrarPelicula(Pelicula p) {
        peliculas.add(p);
    }
 // Listar pelicula
    public void listarPeliculas() {
        for (Pelicula p : peliculas) {
            System.out.println(p);
        }
    }
}