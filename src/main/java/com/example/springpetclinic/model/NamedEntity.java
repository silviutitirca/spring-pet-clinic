package com.example.springpetclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Extension of BaseEntity with a name property.
 * Used as a base class for objects needing these properties.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Override
    public String toString() {
        return this.getName();
    }

}
