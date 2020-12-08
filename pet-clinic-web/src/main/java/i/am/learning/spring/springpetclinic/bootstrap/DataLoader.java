package i.am.learning.spring.springpetclinic.bootstrap;

import i.am.learning.spring.springpetclinic.model.Owner;
import i.am.learning.spring.springpetclinic.model.Pet;
import i.am.learning.spring.springpetclinic.model.PetType;
import i.am.learning.spring.springpetclinic.model.Vet;
import i.am.learning.spring.springpetclinic.services.OwnerService;
import i.am.learning.spring.springpetclinic.services.PetTypeService;
import i.am.learning.spring.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Brunc Street");
        owner1.setCity("Mississauga");
        owner1.setTelephone("3073214532");

        Pet mikyPet = new Pet();
        mikyPet.setPetType(savedDogPetType);
        mikyPet.setOwner(owner1);
        mikyPet.setName("Leo");
        mikyPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikyPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ashely");
        owner2.setLastName("Bruneaue");
        owner2.setAddress("13 Darcel Street");
        owner2.setCity("Mississauga");
        owner2.setTelephone("3087214002");

        Pet nikyPet = new Pet();
        nikyPet.setPetType(savedCatPetType);
        nikyPet.setOwner(owner2);
        nikyPet.setName("Suzi");
        nikyPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(nikyPet);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Dena");
        owner3.setLastName("peterson");
        owner3.setAddress("1762 Albian St.");
        owner3.setCity("Etobicoke");
        owner3.setTelephone("6473521897");

        Pet nikyPet1 = new Pet();
        nikyPet1.setPetType(savedCatPetType);
        nikyPet1.setOwner(owner3);
        nikyPet1.setName("Ketty");
        nikyPet1.setBirthDate(LocalDate.now());
        owner3.getPets().add(nikyPet1);

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
