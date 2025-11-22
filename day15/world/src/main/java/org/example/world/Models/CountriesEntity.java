package org.example.world.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class CountriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 3)
    @NotNull
    @Column(nullable = false, length = 3)
    private String code;

    @Size(max = 52)
    @NotNull
    @Column(nullable = false, length = 52)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String continent;

    @Size(max = 26)
    @NotNull
    @Column(nullable = false, length = 26)
    private String region;

    @NotNull
    @Column(name = "surface_area", nullable = false)
    private Float surfaceArea; // FLOAT type in DB

    @Column(name = "indep_year")
    private Short indepYear;

    @NotNull
    @Column(nullable = false)
    private Integer population;

    @Column(name = "life_expectancy")
    private Float lifeExpectancy; // FLOAT type in DB

    @Column(name = "gnp")
    private Float gnp; // FLOAT type in DB

    @Column(name = "gnp_old")
    private Float gnpOld; // FLOAT type in DB

    @Size(max = 45)
    @NotNull
    @Column(name = "local_name", nullable = false, length = 45)
    private String localName;

    @Size(max = 45)
    @NotNull
    @Column(name = "government_form", nullable = false, length = 45)
    private String governmentForm;

    @Size(max = 60)
    @Column(name = "head_of_state", length = 60)
    private String headOfState;

    @Column(name = "capital")
    private Integer capital;

    @Size(max = 2)
    @NotNull
    @Column(name = "code2", nullable = false, length = 2)
    private String code2;

    @OneToMany(mappedBy = "country")
    private Set<CitiesEntity> cities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "country")
    private Set<LanguagesEntity> languages = new LinkedHashSet<>();

    // --- Getters and Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Float getSurfaceArea() { return surfaceArea; }
    public void setSurfaceArea(Float surfaceArea) { this.surfaceArea = surfaceArea; }

    public Short getIndepYear() { return indepYear; }
    public void setIndepYear(Short indepYear) { this.indepYear = indepYear; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public Float getLifeExpectancy() { return lifeExpectancy; }
    public void setLifeExpectancy(Float lifeExpectancy) { this.lifeExpectancy = lifeExpectancy; }

    public Float getGnp() { return gnp; }
    public void setGnp(Float gnp) { this.gnp = gnp; }

    public Float getGnpOld() { return gnpOld; }
    public void setGnpOld(Float gnpOld) { this.gnpOld = gnpOld; }

    public String getLocalName() { return localName; }
    public void setLocalName(String localName) { this.localName = localName; }

    public String getGovernmentForm() { return governmentForm; }
    public void setGovernmentForm(String governmentForm) { this.governmentForm = governmentForm; }

    public String getHeadOfState() { return headOfState; }
    public void setHeadOfState(String headOfState) { this.headOfState = headOfState; }

    public Integer getCapital() { return capital; }
    public void setCapital(Integer capital) { this.capital = capital; }

    public String getCode2() { return code2; }
    public void setCode2(String code2) { this.code2 = code2; }

    public Set<CitiesEntity> getCities() { return cities; }
    public void setCities(Set<CitiesEntity> cities) { this.cities = cities; }

    public Set<LanguagesEntity> getLanguages() { return languages; }
    public void setLanguages(Set<LanguagesEntity> languages) { this.languages = languages; }
}
