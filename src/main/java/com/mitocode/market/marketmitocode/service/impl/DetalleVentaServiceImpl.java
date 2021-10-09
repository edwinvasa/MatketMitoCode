package com.mitocode.market.marketmitocode.service.impl;

import com.mitocode.market.marketmitocode.model.DetalleVenta;
import com.mitocode.market.marketmitocode.repo.IDetalleVentaRepo;
import com.mitocode.market.marketmitocode.repo.IGenericRepo;
import com.mitocode.market.marketmitocode.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServiceImpl extends CRUDImpl<DetalleVenta, Integer> implements IDetalleVentaService{

    @Autowired
    private IDetalleVentaRepo repo;

    @Override
    IGenericRepo<DetalleVenta, Integer> getRepo() {
        return repo;
    }
}
