package com.mitocode.market.marketmitocode.controller;

import com.mitocode.market.marketmitocode.model.Producto;
import com.mitocode.market.marketmitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public List<Producto> listarTodos() throws Exception {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Producto listarPorId(@PathVariable Integer id) throws Exception {
        return service.listarPorId(id);
    }

    @PostMapping
    public Producto registrar(@RequestBody Producto producto) throws Exception {
        return service.registrar(producto);
    }

    @PutMapping
    public Producto modificar(@Validated @RequestBody Producto producto) throws Exception {
        Producto productoConsulta = service.listarPorId(producto.getIdProducto());
        if (productoConsulta != null) {
            return service.modificar(producto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) throws Exception {
        service.eliminar(id);
    }
}
