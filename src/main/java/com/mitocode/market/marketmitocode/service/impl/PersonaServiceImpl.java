package com.mitocode.market.marketmitocode.service.impl;

import com.mitocode.market.marketmitocode.model.Persona;
import com.mitocode.market.marketmitocode.repo.IGenericRepo;
import com.mitocode.market.marketmitocode.repo.IPersonaRepo;
import com.mitocode.market.marketmitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    IGenericRepo<Persona, Integer> getRepo() {
        return repo;
    }
}
