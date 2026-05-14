package modelos;

import java.time.Duration;
import java.time.LocalTime;

public class Funcion {

    private Pelicula pelicula;

    private Sala sala;

    private LocalTime inicio;

    private LocalTime fin;

    public Funcion(
            Pelicula pelicula,
            Sala sala,
            LocalTime inicio,
            LocalTime fin
    ) {

        this.pelicula = pelicula;
        this.sala = sala;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    // TIEMPO REAL EN MILISEGUNDOS
    public int getDuracionMilis() {

        long minutos = Duration
                .between(inicio, fin)
                .toMinutes();

        // si cruza medianoche
        if(minutos < 0) {
            minutos += 24 * 60;
        }

        return (int)(minutos * 60000);

        // PRUEBAS RÁPIDAS:
        // return (int)(minutos * 1000);
    }

    @Override
    public String toString() {

        return pelicula.getNombre()
                + " | Inicio: "
                + inicio
                + " | Fin: "
                + fin;
    }
}