package modelos;

public class Sala {

    protected int numero;

    protected Asiento[] asientos;

    public Sala(
            int numero,
            int capacidad
    ) {

        this.numero = numero;

        asientos =
                new Asiento[capacidad];

        for(int i = 0;
            i < capacidad;
            i++) {

            asientos[i] =
                    new Asiento(i + 1);
        }
    }

    public int getNumero() {

        return numero;
    }

    public Asiento[] getAsientos() {

        return asientos;
    }
}