package modelos;

public class Funcion {

    private long id;
    private String horaInicio;
    private String horaFin;
    private Pelicula pelicula;

    public Funcion(long id, String horaInicio, String horaFin, Pelicula pelicula) {

        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.pelicula = pelicula;
    }

    public long getId() {
        return id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    @Override
    public String toString() {

        return "Funcion: " + pelicula.getTitulo()
                + " | Inicio: " + horaInicio
                + " | Fin: " + horaFin;
    }
}