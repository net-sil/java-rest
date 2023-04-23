package dev.pasha.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "EMPLOYEES")
public record Employee(@Id Integer id, @Column String name, @Column String role) {
}
