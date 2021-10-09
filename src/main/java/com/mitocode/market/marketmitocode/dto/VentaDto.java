package com.mitocode.market.marketmitocode.dto;

import com.mitocode.market.marketmitocode.model.Persona;

import java.time.LocalDateTime;

public class VentaDto {

    private int idVenta;

    private LocalDateTime fecha;

    private PersonaDto persona;

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

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
