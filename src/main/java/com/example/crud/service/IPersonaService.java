package com.example.crud.service;

import com.example.crud.model.Persona;

import java.util.List;

public interface IPersonaService {
    //método para traer a todas las personas
    public List<Persona> getPersonas();

    //método para dar de alta a una persona
    public void savePersona(Persona perso);

    //método para borrar una persona a través de su id
    public void deletePersona(Long id);

    //método para encontrar una persona a través de su id
    public Persona findPersona(Long id);
    //método para editar una persona
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);

}
