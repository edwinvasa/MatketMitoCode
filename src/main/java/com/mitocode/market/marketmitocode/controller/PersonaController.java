package com.mitocode.market.marketmitocode.controller;

import com.mitocode.market.marketmitocode.dto.PersonaDto;
import com.mitocode.market.marketmitocode.dto.VentaDto;
import com.mitocode.market.marketmitocode.exception.ModeloNotFoundException;
import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.service.IPersonaService;
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
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<PersonaDto>> listarTodos() throws Exception{
        List<PersonaDto> response = service.listar().stream()
                .map(persona -> mapper.map(persona, PersonaDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> listarPorId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(mapper.map(service.listarPorId(id), PersonaDto.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody PersonaDto persona) throws Exception {
        PersonaDto dtoResponse = mapper.map(service.registrar(mapper.map(persona, Persona.class)), PersonaDto.class);
        //localhost:8080/personas/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PersonaDto> modificar(@Valid @RequestBody PersonaDto persona) throws Exception{
        Persona personaConsulta = service.listarPorId(persona.getIdPersona());
        if(personaConsulta == null) {
            throw new ModeloNotFoundException("Id no encontrado " + persona.getIdPersona());
        } else {

            return new ResponseEntity<>(mapper.map(service.modificar(mapper.map(persona, Persona.class)), PersonaDto.class), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
        Persona personaConsulta = service.listarPorId(id);
        if (personaConsulta == null) {
            throw new ModeloNotFoundException("Id no encontrado " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
