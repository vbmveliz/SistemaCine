package modelos;

public class SalaNormal extends Sala {

    public SalaNormal(String nombre, int cantidadAsientos) {
        super(nombre, cantidadAsientos);
    }

    @Override
    public double getPrecio() {
        return 20.0;
    }
}