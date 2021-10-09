package com.mitocode.market.marketmitocode.service.impl;

import com.mitocode.market.marketmitocode.model.Producto;
import com.mitocode.market.marketmitocode.repo.IGenericRepo;
import com.mitocode.market.marketmitocode.repo.IProductoRepo;
import com.mitocode.market.marketmitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    @Autowired
    private IProductoRepo repo;

    @Override
    IGenericRepo getRepo() {
        return repo;
    }
}
