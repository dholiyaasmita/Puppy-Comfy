package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.Owner;
import i.am.learning.spring.springpetclinic.services.OwnerService;
import i.am.learning.spring.springpetclinic.services.PetService;
import i.am.learning.spring.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    private final PetTypeService petTypeService;
    private final PetService petService;


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null){
            if (object.getPets() != null){
                object.getPets();
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
    super.delete(object);
    }

    @Override
    public void deletedById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
