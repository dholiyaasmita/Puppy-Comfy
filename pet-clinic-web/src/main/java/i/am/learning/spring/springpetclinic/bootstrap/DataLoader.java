package i.am.learning.spring.springpetclinic.bootstrap;

import i.am.learning.spring.springpetclinic.model.Owner;
import i.am.learning.spring.springpetclinic.model.PetType;
import i.am.learning.spring.springpetclinic.model.Vet;
import i.am.learning.spring.springpetclinic.services.OwnerService;
import i.am.learning.spring.springpetclinic.services.PetTypeService;
import i.am.learning.spring.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Spring Bean
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Suzanne");
        owner1.setLastName("waiting");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ashely");
        owner2.setLastName("Bruneaue");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Dena");
        owner3.setLastName("peterson");

        ownerService.save(owner3);

        System.out.println("Loaded Owners.....");

        Vet vet = new Vet();
        vet.setFirstName("Lisa");
        vet.setLastName("Real");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Micheal");
        vet1.setLastName("Friend");

        vetService.save(vet1);

        System.out.println("Loaded Vet....");

    }
}
