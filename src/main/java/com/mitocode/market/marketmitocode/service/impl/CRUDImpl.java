package com.mitocode.market.marketmitocode.service.impl;

import com.mitocode.market.marketmitocode.repo.IGenericRepo;
import com.mitocode.market.marketmitocode.service.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    @Autowired
    abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T registrar(T tipo) throws Exception {
        return getRepo().save(tipo);
    }

    @Override
    public T modificar(T tipo) throws Exception {
        return getRepo().save(tipo);
    }

    @Override
    public List<T> listar() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
