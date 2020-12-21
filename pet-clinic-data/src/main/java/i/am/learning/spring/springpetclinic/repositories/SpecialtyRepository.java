package i.am.learning.spring.springpetclinic.repositories;

import i.am.learning.spring.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {
}
