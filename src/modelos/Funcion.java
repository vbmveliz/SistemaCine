package modelos;

public class Funcion {
	private long id;
    private String horario;
    private Pelicula pelicula;

    public Funcion(long id, String horario, Pelicula pelicula) {
        this.id = id;
        this.horario = horario;
        this.pelicula = pelicula;
    }

    public long getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    @Override
    public String toString() {
        return "Funcion: " + pelicula.getTitulo() +
               " - Horario: " + horario;
    }
}
