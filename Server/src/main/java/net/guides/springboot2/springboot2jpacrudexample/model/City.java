package net.guides.springboot2.springboot2jpacrudexample.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="city_name")
    @NotNull(message = "City name should not be null")
    private String name;

    @ManyToOne
    @JoinColumn(name="state_id")
    private State state;

}