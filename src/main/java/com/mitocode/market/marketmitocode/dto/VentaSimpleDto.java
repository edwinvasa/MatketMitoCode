package com.mitocode.market.marketmitocode.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class VentaSimpleDto {

    @JsonIgnore
    private int idVenta;

    private LocalDateTime fecha;

    @JsonIgnore
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
