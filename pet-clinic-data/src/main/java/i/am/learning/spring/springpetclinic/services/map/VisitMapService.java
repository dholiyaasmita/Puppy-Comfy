package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.Visit;
import i.am.learning.spring.springpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null){
            throw  new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public void deletedById(Long id) {
        super.deleteById(id);
    }
}
