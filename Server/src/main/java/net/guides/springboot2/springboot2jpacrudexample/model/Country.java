package net.guides.springboot2.springboot2jpacrudexample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="country_code")
    @NotNull(message = "Country code should not be null")
    private String code;

    @Column(name="country_name")
    @NotNull(message = "Country name should not be null")
    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;

}