package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
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

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        owner1.setAddress("#1 street");
        owner1.setCity("Lazy town");
        owner1.setTelephone("123123123");
        ownerService.save(owner1);

        Pet myDog = new Pet();
        myDog.setPetType(saveDogPetType);
        myDog.setOwner(owner1);
        myDog.setBirthday(LocalDate.now());
        myDog.setName("Laquisha");
        owner1.getPets().add(myDog);

        Owner owner2 = new Owner();
        owner2.setFirstName("Seip");
        owner2.setLastName("Zmogus");
        owner1.setAddress("#2 street");
        owner1.setCity("Lazy town");
        owner1.setTelephone("321321321");
        ownerService.save(owner2);

        Pet fionaCat = new Pet();
        fionaCat.setPetType(saveCatPetType);
        fionaCat.setBirthday(LocalDate.now());
        fionaCat.setName("Fluff");
        fionaCat.setOwner(owner2);
        owner2.getPets().add(fionaCat);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kitas");
        vet1.setLastName("Zmogus");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Deeeez");
        vet2.setLastName("Nutz");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
