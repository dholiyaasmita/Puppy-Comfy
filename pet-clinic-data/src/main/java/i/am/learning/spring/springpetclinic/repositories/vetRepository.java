package i.am.learning.spring.springpetclinic.repositories;

import i.am.learning.spring.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface vetRepository extends CrudRepository<Vet,Long> {
}
