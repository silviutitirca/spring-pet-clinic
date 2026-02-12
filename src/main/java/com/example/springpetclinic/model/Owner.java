package com.example.springpetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple JavaBean domain object representing an owner.
 */
@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets = new HashSet<>();

    @JsonIgnore
    protected Set<Pet> getPetsInternal() {
        if (this.pets == null) {
            this.pets = new HashSet<>();
        }
        return this.pets;
    }

    @JsonIgnore
    protected void setPetsInternal(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
        if (pet.isNew()) {
            getPetsInternal().add(pet);
        }
        pet.setOwner(this);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * @param name to test
     * @return the pet if found
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     * @param name to test
     * @param ignoreNew whether to ignore new pets
     * @return the pet if found
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : getPetsInternal()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                if (compName != null) {
                    compName = compName.toLowerCase();
                    if (compName.equals(name)) {
                        return pet;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Return the Pet with the given id, or null if none found for this Owner.
     * @param id to search for
     * @return the pet if found
     */
    public Pet getPet(Integer id) {
        for (Pet pet : getPetsInternal()) {
            if (!pet.isNew()) {
                Integer targetId = pet.getId();
                if (targetId.equals(id)) {
                    return pet;
                }
            }
        }
        return null;
    }

}
