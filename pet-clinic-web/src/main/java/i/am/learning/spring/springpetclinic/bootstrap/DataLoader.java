package i.am.learning.spring.springpetclinic.bootstrap;

import i.am.learning.spring.springpetclinic.model.Owner;
import i.am.learning.spring.springpetclinic.model.Vet;
import i.am.learning.spring.springpetclinic.services.OwnerService;
import i.am.learning.spring.springpetclinic.services.VetService;
import i.am.learning.spring.springpetclinic.services.map.OwnerServiceMap;
import i.am.learning.spring.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Spring Bean
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {

        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(11L);
        owner1.setFirstName("Suzanne");
        owner1.setLastName("waiting");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(12L);
        owner1.setFirstName("Ashely");
        owner1.setLastName("Bruneaue");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet = new Vet();
        vet.setId(11L);
        vet.setFirstName("Lisa");
        vet.setLastName("Real");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet.setId(12L);
        vet.setFirstName("Micheal");
        vet.setLastName("Friend");

        vetService.save(vet1);

        System.out.println("Loaded Vet....");

    }
}
