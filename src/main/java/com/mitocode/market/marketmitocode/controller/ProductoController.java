package com.mitocode.market.marketmitocode.controller;

import com.mitocode.market.marketmitocode.dto.ProductoDto;
import com.mitocode.market.marketmitocode.exception.ModeloNotFoundException;
import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.model.Producto;
import com.mitocode.market.marketmitocode.service.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarTodos() throws Exception {
        List<ProductoDto> response = service.listar().stream()
                .map(producto -> mapper.map(producto, ProductoDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> listarPorId(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(service.listarPorId(id), ProductoDto.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody ProductoDto producto) throws Exception {
        ProductoDto dtoResponse = mapper.map(service.registrar(mapper.map(producto, Producto.class)), ProductoDto.class);
        //localhost:8080/productos/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ProductoDto> modificar(@Valid @RequestBody ProductoDto producto) throws Exception {
        Producto productoConsulta = service.listarPorId(producto.getIdProducto());
        if (productoConsulta == null) {
            throw new ModeloNotFoundException("Id no encontrado " + producto.getIdProducto());
        }else{
            ProductoDto response = mapper.map(service.modificar(
                                                mapper.map(producto, Producto.class)
                                                ), ProductoDto.class);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
        Producto productoConsulta = service.listarPorId(id);
        if (productoConsulta == null) {
            throw new ModeloNotFoundException("Id no encontrado " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
