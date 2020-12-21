package i.am.learning.spring.springpetclinic.repositories;

import i.am.learning.spring.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
