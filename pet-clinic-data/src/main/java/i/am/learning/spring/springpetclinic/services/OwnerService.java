package i.am.learning.spring.springpetclinic.services;

import i.am.learning.spring.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
