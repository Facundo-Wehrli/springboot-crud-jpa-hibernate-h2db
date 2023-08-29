package com.example.crud.controller;

import com.example.crud.model.Persona;
import com.example.crud.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService iPersonaService;

    //endpoint para traer todas las personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return iPersonaService.getPersonas();
    }

    //endpoint para crear una nueva persona
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona perso) {
        iPersonaService.savePersona(perso);
        return "Persona creada";
    }

    //endpoint para dar de baja una nueva persona
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        //string que avisa que la persona fue eliminada correctamente
        return "Persona eliminada correctamente";
    }

    //endpoint para modificar una persona
    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam(required = false, name = "id") Long idNueva,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaEdad
    ) {
        // envío id original (para buscar)
        // envío id nueva (para modificar)
        iPersonaService.editPersona(id_original, idNueva, nuevoNombre, nuevoApellido, nuevaEdad);
        //busco la persona editada para mostrarla en la response
        Persona perso = iPersonaService.findPersona(idNueva);
        //retorno la nueva persona
        return perso;

    }


}
