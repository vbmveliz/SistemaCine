package modelos;

public class SalaVIP extends Sala {

    public SalaVIP(String nombre, int cantidadAsientos) {
        super(nombre, cantidadAsientos);
    }

    @Override
    public double getPrecio() {
        return 35.0;
    }
}