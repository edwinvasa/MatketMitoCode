package com.mitocode.market.marketmitocode.service;

import com.mitocode.market.marketmitocode.dto.VentaTransaccionalDto;
import com.mitocode.market.marketmitocode.model.DetalleVenta;
import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.model.Venta;

import java.util.List;

public interface IVentaService extends ICRUD<Venta, Integer>{


    Venta registrarTransaccional(Persona persona, Venta venta, List<DetalleVenta> detalleVentas);
}
