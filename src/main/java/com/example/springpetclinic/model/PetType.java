package com.example.springpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Simple JavaBean domain object representing a pet type.
 */
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {
}
