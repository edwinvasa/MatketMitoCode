package com.mitocode.market.marketmitocode.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductoDto {

    private Integer idProducto;

    @NotNull
    @Size(min = 3, max = 16, message = "{nombre.size}")
    private String nombre;

    @NotNull
    @Size(min = 3, max = 16, message = "{marca.size}")
    private String marca;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
