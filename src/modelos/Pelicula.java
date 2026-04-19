package modelos;

public class Pelicula {
    private long id;
    private String titulo;
    private int duracion;

    public Pelicula(long id, String titulo, int duracion) {
        this.setId(id);
        this.titulo = titulo;
        this.setDuracion(duracion);
    }

    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        return titulo;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}