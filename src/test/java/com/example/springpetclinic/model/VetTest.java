package com.example.springpetclinic.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        @DisplayName("Should return sorted specialties by name")
        void shouldReturnSortedSpecialties() {
            // Given
            Specialty s1 = new Specialty();
            s1.setName("Z - " + faker.job().field());
            
            Specialty s2 = new Specialty();
            s2.setName("A - " + faker.job().field());
            
            Specialty s3 = new Specialty();
            s3.setName("M - " + faker.job().field());

            // When
            vet.addSpecialty(s1);
            vet.addSpecialty(s2);
            vet.addSpecialty(s3);

            List<Specialty> sorted = vet.getSpecialties();

            // Then
            assertThat(sorted).hasSize(3);
            assertThat(sorted.get(0).getName()).isEqualTo(s2.getName());
            assertThat(sorted.get(1).getName()).isEqualTo(s3.getName());
            assertThat(sorted.get(2).getName()).isEqualTo(s1.getName());
        }

        @Test
        @DisplayName("Should return unmodifiable list of specialties")
        void shouldReturnUnmodifiableList() {
            // Given
            Specialty s1 = new Specialty();
            s1.setName(faker.job().field());
            vet.addSpecialty(s1);

            // When
            List<Specialty> specialties = vet.getSpecialties();
            
            // Then
            assertThrows(UnsupportedOperationException.class, () -> {
                specialties.clear();
            });
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
