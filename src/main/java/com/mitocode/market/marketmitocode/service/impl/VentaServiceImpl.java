package com.mitocode.market.marketmitocode.service.impl;

import com.mitocode.market.marketmitocode.dto.VentaTransaccionalDto;
import com.mitocode.market.marketmitocode.model.DetalleVenta;
import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.model.Venta;
import com.mitocode.market.marketmitocode.repo.IDetalleVentaRepo;
import com.mitocode.market.marketmitocode.repo.IGenericRepo;
import com.mitocode.market.marketmitocode.repo.IVentaRepo;
import com.mitocode.market.marketmitocode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

    @Autowired
    private IVentaRepo repo;

    @Autowired
    private IDetalleVentaRepo detalleVentaRepo;

    @Override
    IGenericRepo<Venta, Integer> getRepo() {
        return repo;
    }


    @Transactional
    @Override
    public Venta registrarTransaccional(Persona persona, Venta venta, List<DetalleVenta> detalleVentas) {
        venta.setPersona(persona);

        detalleVentas.forEach(detalleVenta -> detalleVenta.setVenta(venta));
        Venta ventaRegistrada = repo.save(venta);

        detalleVentaRepo.saveAll(detalleVentas);

        return ventaRegistrada;
    }
}
