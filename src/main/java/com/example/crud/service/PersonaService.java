package com.example.crud.service;

import com.example.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
}
