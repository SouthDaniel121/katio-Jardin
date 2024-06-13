package edu.eafit.katio.services;

import java.util.Optional;

import edu.eafit.katio.interfaces.BaseNarratorService;
import edu.eafit.katio.models.Narrators;
import edu.eafit.katio.repository.NarratorRepository;

public class NarratorService implements BaseNarratorService {
    
    private NarratorRepository _narratorRepository;

    public NarratorService(NarratorRepository narratorRepository){
        _narratorRepository = narratorRepository;
    }

    // Traer todos los narradores
    @Override
    public Iterable<Narrators> getAllNarrators() {
        var narratorList = _narratorRepository.findAll();
        return narratorList;
    }

    // Traer Narradores por Id
    @Override
    public Iterable<Narrators> getNarratorsById(Integer Id) {
        var narratorList = _narratorRepository.findById(Id);
        return narratorList;
    }

    // Traer Narradores por Nombre
    @Override 
    public Iterable<Narrators> getNarratorsByName(String Name) {
        var narratorList = _narratorRepository.findByName(Name);
        return narratorList;
    }

    // Traer Narradores por Apellido
    @Override 
    public Iterable<Narrators> getNarratorsByLastName(String LastName) {
        var narratorList = _narratorRepository.findByLastName(LastName);
        return narratorList;
    }

    // Traer Narradores por Genero
    @Override
    public Iterable<Narrators> getNarratorsByGenre(String Genre) {
        var narratorList = _narratorRepository.findByGenre(Genre);
        return narratorList;
    }

    // Crear Narrador
    @Override 
    public Narrators addNarrators(Narrators narrators) {

        Optional<Narrators> existingNarrator = _narratorRepository.findByNameOpt(narrators.getName());
        if (existingNarrator.isPresent()) {
            throw new RuntimeException("El narrador ya existe");
        } 
        return _narratorRepository.saveAndFlush(narrators);
    }

    // Editar Narrador
    @Override
    public Narrators updateNarrators(String name, Narrators narrators) {
        Optional<Narrators> oldNarrator = _narratorRepository.findByNameOpt(name);
        if (oldNarrator.isPresent() && !oldNarrator.get().getName().isBlank()) 
        {
            oldNarrator.get().setName(narrators.getName());
            oldNarrator.get().setLastname(narrators.getLastname());
            oldNarrator.get().setGenre(narrators.getGenre());

            return _narratorRepository.saveAndFlush(oldNarrator.get());
        } else {
            return null;
        }
    }
}
