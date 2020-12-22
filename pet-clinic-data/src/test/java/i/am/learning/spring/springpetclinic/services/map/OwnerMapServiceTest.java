package i.am.learning.spring.springpetclinic.services.map;

import i.am.learning.spring.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName="Ross";
    @BeforeEach
    public void setUp(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void findAll() {
    Set<Owner> ownerSet=ownerMapService.findAll();
    assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner1 = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner1);
        assertEquals(id,saveOwner.getId());

    }
    @Test
    void saveNoId(){
        Owner saveOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deletedById() {
        ownerMapService.deletedById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner ross = ownerMapService.findByLastName(lastName);
        assertNotNull(ross);
        assertEquals(ownerId,ross.getId());
    }

    @Test
    void findByLastNameFound() {
        Owner ross = ownerMapService.findByLastName("foo");
        assertNull(ross);
        //assertEquals(ownerId,ross.getId());
    }
}

