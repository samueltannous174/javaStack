package org.example.world.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class CitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 35)
    @NotNull
    @Column(nullable = false, length = 35)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String district;

    @NotNull
    @Column(nullable = false)
    private Integer population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountriesEntity country;

    // --- Getters and Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public CountriesEntity getCountry() { return country; }
    public void setCountry(CountriesEntity country) { this.country = country; }
}
