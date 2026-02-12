package com.example.springpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Simple JavaBean domain object representing a visit.
 */
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "visit_date", columnDefinition = "DATE")
    private LocalDate date;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /**
     * Creates a new instance of Visit for the current date.
     */
    public Visit() {
        this.date = LocalDate.now();
    }

}
