package com.mitocode.market.marketmitocode.service;

import java.util.List;

public interface ICRUD<T, ID> {

    T registrar(T tipo) throws Exception;
    T modificar(T tipo) throws Exception;
    List<T> listar() throws Exception;
    T listarPorId(ID id) throws Exception;
    void eliminar(ID id) throws Exception;
}
