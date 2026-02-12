package com.example.springpetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean domain object representing a pet.
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.LAZY)
    private List<Visit> visits = new ArrayList<>();

    @JsonIgnore
    protected List<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new ArrayList<>();
        }
        return this.visits;
    }

    @JsonIgnore
    protected void setVisitsInternal(List<Visit> visits) {
        this.visits = visits;
    }

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setPet(this);
    }

}
