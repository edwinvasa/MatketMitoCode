package com.mitocode.market.marketmitocode.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Venta {

    @Column(name = "idventa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "idpersona", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_pesona"))
    private Persona persona;

    private Double importe;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
