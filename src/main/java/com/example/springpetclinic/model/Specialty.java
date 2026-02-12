package com.example.springpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Simple JavaBean domain object representing a specialty for a Vet.
 */
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
}
