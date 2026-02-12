package com.example.springpetclinic.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Owner Entity Tests")
class OwnerTest {

    private Owner owner;
    private Faker faker;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        faker = new Faker();
    }

    @Nested
    @DisplayName("Pet Management Tests")
    class PetManagementTests {

        @Test
        @DisplayName("Should add a new pet to the owner")
        void shouldAddPet() {
            Pet pet = new Pet();
            pet.setName(faker.dog().name());

            owner.addPet(pet);

            assertThat(owner.getPets()).hasSize(1);
            assertThat(owner.getPets()).contains(pet);
        }

        @Test
        @DisplayName("Should get pet by name (case insensitive)")
        void shouldGetPetByName() {
            String petName = "Buddy";
            Pet pet = new Pet();
            pet.setName(petName);
            owner.addPet(pet);

            Pet found = owner.getPet("buddy");
            Pet notFound = owner.getPet("Missing");

            assertThat(found).isNotNull();
            assertThat(found.getName()).isEqualTo(petName);
            assertThat(notFound).isNull();
        }

        @Test
        @DisplayName("Should get pet by id")
        void shouldGetPetById() {
            Pet pet = new Pet();
            pet.setId(1);
            pet.setName(faker.dog().name());
            
            // Note: addPet adds to the set only if pet isNew() (id is null) in my implementation 
            // but standard pet clinic implementation usually adds it if it's new.
            // Let's check my addPet implementation:
            // if (pet.isNew()) { getPetsInternal().add(pet); }
            
            // If I set id before addPet, it won't be added to the set in my current implementation.
            // Let's adjust the test or the implementation.
            
            Pet pet2 = new Pet();
            pet2.setName(faker.dog().name());
            owner.addPet(pet2);
            pet2.setId(2); // Set ID after adding

            Pet found = owner.getPet(2);
            Pet notFound = owner.getPet(99);

            assertThat(found).isNotNull();
            assertThat(found.getId()).isEqualTo(2);
            assertThat(notFound).isNull();
        }
        
        @Test
        @DisplayName("Should handle multiple pets")
        void shouldHandleMultiplePets() {
            Pet p1 = new Pet();
            p1.setName("Alpha");
            owner.addPet(p1);
            
            Pet p2 = new Pet();
            p2.setName("Beta");
            owner.addPet(p2);
            
            assertThat(owner.getPets()).hasSize(2);
            assertThat(owner.getPet("Alpha")).isEqualTo(p1);
            assertThat(owner.getPet("Beta")).isEqualTo(p2);
        }
    }
}
