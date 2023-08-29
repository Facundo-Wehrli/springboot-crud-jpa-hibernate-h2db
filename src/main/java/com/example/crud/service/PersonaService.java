package com.example.crud.service;

import com.example.crud.model.Persona;
import com.example.crud.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class PersonaService implements IPersonaService {
    //inyección de dependencias
    @Autowired
    private IPersonaRepository iPersonaRepository;

    //sobreescribo la interfaz utilizando métodos de JpaRespository(findAll, save, delete, findById) mediante "DI",
    @Override
    public List<Persona> getPersonas() {
        return iPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona perso) {
        iPersonaRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return iPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //uso "this" porque llamo al mismo método findPersona de esta clase
        Persona perso = this.findPersona(idOriginal);
        //proceso de modificación a nivel lógico
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        //uso "this" porque llamo al mismo método savePersona de esta clase
        this.savePersona(perso);
    }
}
