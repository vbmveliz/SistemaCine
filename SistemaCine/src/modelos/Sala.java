package modelos;

public abstract class Sala {

    protected String nombre;
    protected Asiento[] asientos;

    public Sala(String nombre, int cantidadAsientos) {

        this.nombre = nombre;

        asientos = new Asiento[cantidadAsientos];

        for(int i = 0; i < cantidadAsientos; i++) {
            asientos[i] = new Asiento(i + 1);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Asiento[] getAsientos() {
        return asientos;
    }

    public abstract double getPrecio();
}