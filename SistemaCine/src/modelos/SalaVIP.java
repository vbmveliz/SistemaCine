package modelos;

public class SalaVIP extends Sala {

    private double precioExtra;

    public SalaVIP(
            int numero,
            int capacidad,
            double precioExtra
    ) {

        super(numero, capacidad);

        this.precioExtra = precioExtra;
    }

    public double getPrecioExtra() {

        return precioExtra;
    }

    public void setPrecioExtra(
            double precioExtra
    ) {

        this.precioExtra = precioExtra;
    }

    // =========================
    // RESERVAR ASIENTO
    // =========================

    public boolean reservarAsiento(
            int asiento
    ) {

        if(asiento >= 0 &&
           asiento < asientos.length) {

            if(!asientos[asiento]
                    .isOcupado()) {

                asientos[asiento]
                        .reservar();

                return true;
            }
        }

        return false;
    }
}