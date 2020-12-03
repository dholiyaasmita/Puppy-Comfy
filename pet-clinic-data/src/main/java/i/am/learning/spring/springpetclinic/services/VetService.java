package i.am.learning.spring.springpetclinic.services;

import i.am.learning.spring.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByID(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
