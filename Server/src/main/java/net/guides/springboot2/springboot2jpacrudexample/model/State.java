package net.guides.springboot2.springboot2jpacrudexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="state_name")
    @NotNull(message = "State name should not be null")
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(mappedBy = "state")
    @JsonIgnore
    private List<City> cities;

}