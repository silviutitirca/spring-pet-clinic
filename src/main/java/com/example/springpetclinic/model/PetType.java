package com.example.springpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Simple JavaBean domain object representing a pet type.
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "types")
public class PetType extends NamedEntity {
}
