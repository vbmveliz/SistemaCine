package procesos;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

public class Neg_Reservas {
    
    // Lista 
    private List<Reservas> listaReservas;

    public Neg_Reservas() {
        this.listaReservas = new ArrayList<>();
    }

    // Método para agregar una reserva
    public void agregar(Reservas reserva) {
        if (reserva != null) {
            listaReservas.add(reserva);
            System.out.println("Reserva agregada con éxito. ID: " + reserva.getReservaId());
        } else {
            System.out.println("Error: La reserva no puede ser nula.");
        }
    }

    // Método para listar todas las reservas
    public List<Reservas> listar() {
        return new ArrayList<>(listaReservas);
    }
}