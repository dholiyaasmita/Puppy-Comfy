package i.am.learning.spring.springpetclinic.repositories;

import i.am.learning.spring.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
