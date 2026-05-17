package modelos;

public class SalaNormal extends Sala {

    public SalaNormal(
            int numero,
            int capacidad
    ) {

        super(numero, capacidad);
    }

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