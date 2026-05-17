package procesos;

import java.util.ArrayList;

import modelos.Asiento;
import modelos.Pelicula;
import modelos.Sala;

public class CineService {

    private ArrayList<Pelicula> peliculas;
    private ArrayList<Sala> salas;

    public CineService() {

        peliculas = new ArrayList<>();
        salas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula p) {
        peliculas.add(p);
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public boolean reservarAsiento(int salaNum,
            int asientoNum) {

        for(Sala s : salas) {

            if(s.getNumero() == salaNum) {

                for(Asiento a : s.getAsientos()) {

                    if(a.getNumero() == asientoNum) {

                        if(!a.isOcupado()) {
                            a.reservar();
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}