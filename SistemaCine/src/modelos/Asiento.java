package modelos;

public class Asiento {

    private int numero;
    private boolean ocupado;

    public Asiento(int numero) {

        this.numero = numero;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void reservar() {
        ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }
}