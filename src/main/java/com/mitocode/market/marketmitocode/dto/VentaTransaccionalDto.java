package com.mitocode.market.marketmitocode.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class VentaTransaccionalDto {

    @NotNull
    private PersonaSimpleDto persona;

    @NotNull
    private VentaSimpleDto venta;

    @NotNull
    private List<DetalleVentaDto> detalleVenta;

    public PersonaSimpleDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaSimpleDto persona) {
        this.persona = persona;
    }

    public VentaSimpleDto getVenta() {
        return venta;
    }

    public void setVenta(VentaSimpleDto venta) {
        this.venta = venta;
    }

    public List<DetalleVentaDto> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVentaDto> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
