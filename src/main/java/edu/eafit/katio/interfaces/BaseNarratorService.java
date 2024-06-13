package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.Narrators;

public interface BaseNarratorService {
    Iterable<Narrators> getAllNarrators();
    Iterable<Narrators> getNarratorsById(Integer Id);
    Iterable<Narrators> getNarratorsByName(String Name);
    Iterable<Narrators> getNarratorsByLastName(String LastName);
    Iterable<Narrators> getNarratorsByGenre(String Genre);

    Narrators addNarrators(Narrators narrators);

    Narrators updateNarrators(String name, Narrators narrators);
}
