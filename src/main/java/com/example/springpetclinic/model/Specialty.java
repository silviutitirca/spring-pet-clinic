package com.example.springpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Simple JavaBean domain object representing a specialty for a Vet.
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "specialties")
public class Specialty extends NamedEntity {
}
