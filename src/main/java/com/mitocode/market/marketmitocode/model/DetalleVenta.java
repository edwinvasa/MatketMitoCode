package com.mitocode.market.marketmitocode.model;

import javax.persistence.*;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta {

    @Id
    @Column(name = "iddetalleventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "idventa", nullable = false, foreignKey = @ForeignKey(name = "FK_ventadetalle_venta"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idproducto", nullable = false, foreignKey = @ForeignKey(name = "FK_ventadetalle_producto"))
    private Producto producto;

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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
