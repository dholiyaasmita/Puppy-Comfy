package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.PetType;
import i.am.learning.spring.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long>implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public void deletedById(Long id) {
        super.deleteById(id);
    }
}
