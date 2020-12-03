package i.am.learning.spring.springpetclinic.services;

import i.am.learning.spring.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByID(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
