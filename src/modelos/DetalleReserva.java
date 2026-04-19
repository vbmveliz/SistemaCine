package modelos;
import java.time.LocalDateTime;

public class DetalleReserva extends Reservas {
    private Integer detalleId;
    private String numeroAsiento;
    private Double precioAplicado;

    // Constructor
    public DetalleReserva() {
        super();
    }

    // Constructor
    public DetalleReserva(Integer reservaId, Integer funcionId, Integer clienteId, 
                          LocalDateTime fechaReserva, Double montoTotal, String estado, 
                          Integer detalleId, String numeroAsiento, Double precioAplicado) {
         super(reservaId, funcionId, clienteId, fechaReserva, montoTotal, estado);
        this.detalleId = detalleId;
        this.numeroAsiento = numeroAsiento;
        this.precioAplicado = precioAplicado;
    }

    // Getters y Setters
    public Integer getDetalleId() { return detalleId; }
    public void setDetalleId(Integer detalleId) { this.detalleId = detalleId; }

    public String getNumeroAsiento() { return numeroAsiento; }
    public void setNumeroAsiento(String numeroAsiento) { this.numeroAsiento = numeroAsiento; }

    public Double getPrecioAplicado() { return precioAplicado; }
    public void setPrecioAplicado(Double precioAplicado) { this.precioAplicado = precioAplicado; }
}