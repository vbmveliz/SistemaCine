package procesos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelos.DetalleReserva;

public class Neg_DetalleReserva {
	private List<DetalleReserva> listaDetalles;

    public Neg_DetalleReserva() {
        this.listaDetalles = new ArrayList<>();
    }

    // Método para agregar un detalle de reserva
    public void agregar(DetalleReserva detalle) {
        if (detalle != null && detalle.getNumeroAsiento() != null) {
            listaDetalles.add(detalle);
            System.out.println("Asiento " + detalle.getNumeroAsiento() + " agregado al detalle.");
        } else {
            System.out.println("Error: El detalle o el número de asiento es inválido.");
        }
    }

    // Método para listar todos los detalles
    public List<DetalleReserva> listar() {
        return new ArrayList<>(listaDetalles);
    }

    // Método adicional de negocio: Listar detalles por el ID de la reserva padre
    public List<DetalleReserva> listarPorReserva(Integer reservaId) {
        return listaDetalles.stream()
                .filter(d -> d.getReservaId().equals(reservaId))
                .collect(Collectors.toList());
    }
}
