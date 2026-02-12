package com.example.springpetclinic.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Vet Entity Tests")
class VetTest {

    private Vet vet;
    private Faker faker;

    @BeforeEach
    void setUp() {
        vet = new Vet();
        faker = new Faker();
    }

    @Nested
    @DisplayName("Specialties management")
    class SpecialtiesTests {

        @Test
        @DisplayName("Should return specialties")
        void shouldReturnSpecialties() {
            // Given
            Specialty s1 = new Specialty();
            s1.setName(faker.job().field());
            
            Specialty s2 = new Specialty();
            s2.setName(faker.job().field());

            // When
            vet.addSpecialty(s1);
            vet.addSpecialty(s2);

            Set<Specialty> specialties = vet.getSpecialties();

            // Then
            assertThat(specialties).hasSize(2);
            assertThat(specialties).contains(s1, s2);
        }

        @Test
        @DisplayName("Should return correct number of specialties")
        void shouldReturnNrOfSpecialties() {
            // Then
            assertThat(vet.getNrOfSpecialties()).isEqualTo(0);
            
            // When
            Specialty s1 = new Specialty();
            s1.setName(faker.job().field());
            vet.addSpecialty(s1);
            
            // Then
            assertThat(vet.getNrOfSpecialties()).isEqualTo(1);
        }

        @Test
        @DisplayName("Should clear specialties")
        void shouldClearSpecialties() {
            // Given
            Specialty s1 = new Specialty();
            s1.setName(faker.job().field());
            vet.addSpecialty(s1);
            
            // When
            vet.clearSpecialties();
            
            // Then
            assertThat(vet.getNrOfSpecialties()).isEqualTo(0);
        }
    }
}
