package edu.eafit.katio.interfaces;

import java.util.Optional;

import edu.eafit.katio.models.Narrator;

public interface BaseNarratorService {
    
    Iterable<Narrator> getAllNarrator();
    Narrator addNarrator(Narrator narrator);
    Optional<Narrator> geNarratorById(Integer id);
    
    
}
 