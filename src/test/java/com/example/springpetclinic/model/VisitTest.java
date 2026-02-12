package com.example.springpetclinic.model;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Visit Entity Tests")
class VisitTest {

    private Visit visit;
    private Faker faker;

    @BeforeEach
    void setUp() {
        visit = new Visit();
        faker = new Faker();
    }

    @Test
    @DisplayName("Should initialize with current date")
    void shouldInitializeWithCurrentDate() {
        assertThat(visit.getDate()).isEqualTo(LocalDate.now());
    }

    @Test
    @DisplayName("Should set and get description")
    void shouldSetAndGetDescription() {
        String description = faker.lorem().sentence();
        visit.setDescription(description);
        assertThat(visit.getDescription()).isEqualTo(description);
    }

    @Test
    @DisplayName("Should set and get pet")
    void shouldSetAndGetPet() {
        Pet pet = new Pet();
        pet.setName(faker.dog().name());
        visit.setPet(pet);
        assertThat(visit.getPet()).isEqualTo(pet);
    }
}
