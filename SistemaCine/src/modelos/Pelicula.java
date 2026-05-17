package modelos;

public class Pelicula {

    private String nombre;
    private Genero genero;
    private Director director;
    private String duracion;

    public Pelicula(String nombre, Genero genero,
            Director director, String duracion2) {

        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion2;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public Director getDirector() {
        return director;
    }

    public String getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return nombre + " - " + genero +
                " - " + director.getNombres();
    }
}