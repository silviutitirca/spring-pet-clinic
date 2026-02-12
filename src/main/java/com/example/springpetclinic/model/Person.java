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
 * Simple JavaBean domain object adding person properties to BaseEntity.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotEmpty
    protected String firstName;

    @Column(name = "last_name")
    @NotEmpty
    protected String lastName;

}
