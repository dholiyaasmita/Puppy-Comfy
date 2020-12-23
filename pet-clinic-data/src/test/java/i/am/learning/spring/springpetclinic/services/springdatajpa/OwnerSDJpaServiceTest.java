package i.am.learning.spring.springpetclinic.services.springdatajpa;

import i.am.learning.spring.springpetclinic.model.Owner;
import i.am.learning.spring.springpetclinic.repositories.OwnerRepository;
import i.am.learning.spring.springpetclinic.repositories.PetRepository;
import i.am.learning.spring.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Ross";
        @Mock
        OwnerRepository ownerRepository;
        @Mock
        PetRepository petRepository;
        @Mock
        PetTypeRepository petTypeRepository;
        @InjectMocks
        OwnerSDJpaService ownerSDJpaService;

        Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository .findByLastName(any())).thenReturn(returnOwner);
        Owner Ross = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,Ross.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerOptional = new HashSet<>();
        ownerOptional.add(Owner.builder().id(1L).build());
        ownerOptional.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerOptional);
        Set<Owner> ownerSet = ownerSDJpaService.findAll();
        assertNotNull(ownerSet);
        assertEquals(2,ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
       ownerSDJpaService.delete(returnOwner);
       //defualt is 1 times
       verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deletedById() {
        ownerSDJpaService.deletedById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}
