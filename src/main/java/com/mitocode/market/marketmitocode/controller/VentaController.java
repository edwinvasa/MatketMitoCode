package com.mitocode.market.marketmitocode.controller;

import com.mitocode.market.marketmitocode.dto.VentaDto;
import com.mitocode.market.marketmitocode.dto.VentaTransaccionalDto;
import com.mitocode.market.marketmitocode.model.DetalleVenta;
import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.model.Venta;
import com.mitocode.market.marketmitocode.service.IVentaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public List<Venta> listarTodos() throws Exception {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Venta listarPorId(@PathVariable Integer id) throws Exception {
        return service.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Validated @RequestBody VentaTransaccionalDto dtoRequest) throws Exception {

        Persona persona = mapper.map(dtoRequest.getPersona(), Persona.class);
        Venta venta = mapper.map(dtoRequest.getVenta(), Venta.class);
        List<DetalleVenta> detalleVentas = mapper.map(dtoRequest.getDetalleVenta(), new TypeToken<List<DetalleVenta>>() {}.getType());

        Venta ventaRegistro = service.registrarTransaccional(persona, venta, detalleVentas);
        VentaDto dtoResponse = mapper.map(ventaRegistro, VentaDto.class);

        //localhost:8080/ventas/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdVenta()).toUri();
        return ResponseEntity.created(location).build();
    }
}
