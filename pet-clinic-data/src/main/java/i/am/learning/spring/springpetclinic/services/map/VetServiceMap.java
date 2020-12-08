package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.Speciality;
import i.am.learning.spring.springpetclinic.model.Vet;
import i.am.learning.spring.springpetclinic.services.SpecialtyService;
import i.am.learning.spring.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.finfById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpeciality().size()>0){
            object.getSpeciality().forEach(speciality -> {
                if (speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void deletedById(Long id) {
        super.deleteById(id);
    }
}
