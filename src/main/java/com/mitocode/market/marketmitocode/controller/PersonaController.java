package com.mitocode.market.marketmitocode.controller;

import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public List<Persona> listarTodos() throws Exception{
        return service.listar();
    }

    @GetMapping("/{id}")
    public Persona listarPorId(@PathVariable Integer id) throws Exception{
        return service.listarPorId(id);
    }

    @PostMapping
    public Persona registrar(@RequestBody Persona persona) throws Exception {
        return service.registrar(persona);
    }

    @PutMapping
    public Persona modificar(@Validated @RequestBody Persona persona) throws Exception{
        Persona personaConsulta = service.listarPorId(persona.getIdPersona());
        if(personaConsulta != null){
            return service.modificar(persona);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) throws Exception{
        service.eliminar(id);
    }
}
