package edu.eafit.katio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import edu.eafit.katio.interfaces.BaseNarratorService;
import edu.eafit.katio.models.Narrator;
import edu.eafit.katio.repository.NarratorRepository;

@Service
//Implementa la superClase De base NarratorService 
public class NarratorService implements BaseNarratorService {
    @Autowired
    private NarratorRepository narratorRepository;
    

      public NarratorService(NarratorService narratorService) {
        this.narratorRepository = (NarratorRepository) narratorService;
    }

    public Narrator addNarrator(Narrator narrator) {
        if (narrator.getName() == null || narrator.getName().isEmpty()) {
            throw new IllegalArgumentException("Narrator name cannot be null or empty");
        }

        try {
            return NarratorRepository.saveAndFlush(narrator);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error save narrator", ex);
        }
    }


    @Override
    public Iterable<Narrator> getAllNarrator() {
        var narratorList = narratorRepository.findAll();
        return narratorList;
    }

    @Override
    public Optional<Narrator> geNarratorById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geNarratorById'");
    }

    

} 
