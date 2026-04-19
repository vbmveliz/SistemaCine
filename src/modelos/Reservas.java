package modelos;

import java.time.LocalDateTime;

public class Reservas {
    private Integer reservaId;
    private Integer funcionId;
    private Integer clienteId;
    private LocalDateTime fechaReserva;
    private Double montoTotal;
    private String estado;

    // Constructor
    public Reservas() {
    }

    // Constructor con todas las variables
    public Reservas(Integer reservaId, Integer funcionId, Integer clienteId, 
                   LocalDateTime fechaReserva, Double montoTotal, String estado) {
        this.reservaId = reservaId;
        this.funcionId = funcionId;
        this.clienteId = clienteId;
        this.fechaReserva = fechaReserva;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }

    public Integer getFuncionId() { return funcionId; }
    public void setFuncionId(Integer funcionId) { this.funcionId = funcionId; }

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }

    public Double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(Double montoTotal) { this.montoTotal = montoTotal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}