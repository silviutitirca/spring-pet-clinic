package com.example.springpetclinic.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Pet Entity Tests")
class PetTest {

    private Pet pet;
    private Faker faker;

    @BeforeEach
    void setUp() {
        pet = new Pet();
        faker = new Faker();
    }

    @Test
    @DisplayName("Should set and get birth date")
    void shouldSetAndGetBirthDate() {
        LocalDate birthDate = LocalDate.now().minusYears(2);
        pet.setBirthDate(birthDate);
        assertThat(pet.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    @DisplayName("Should set and get pet type")
    void shouldSetAndGetPetType() {
        PetType type = new PetType();
        type.setName("Dog");
        pet.setType(type);
        assertThat(pet.getType()).isEqualTo(type);
        assertThat(pet.getType().getName()).isEqualTo("Dog");
    }

    @Test
    @DisplayName("Should set and get owner")
    void shouldSetAndGetOwner() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        pet.setOwner(owner);
        assertThat(pet.getOwner()).isEqualTo(owner);
    }

    @Test
    @DisplayName("Should add visit to pet")
    void shouldAddVisit() {
        Visit visit = new Visit();
        visit.setDescription("Checkup");

        pet.addVisit(visit);

        assertThat(pet.getVisits()).hasSize(1);
        assertThat(pet.getVisits()).contains(visit);
        assertThat(visit.getPet()).isEqualTo(pet);
    }
}
