package i.am.learning.spring.springpetclinic.repositories;

import i.am.learning.spring.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
