package com.mitocode.market.marketmitocode.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mitocode.market.marketmitocode.model.Venta;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DetalleVentaDto {

    @JsonIgnore
    private Integer idDetalleVenta;

    @JsonIgnore
    private Venta venta;

    @NotNull
    private ProductoSimpleDto producto;

    @NotEmpty
    private Integer cantidad;

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ProductoSimpleDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoSimpleDto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
