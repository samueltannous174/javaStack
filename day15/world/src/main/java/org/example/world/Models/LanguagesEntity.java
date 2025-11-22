package org.example.world.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "languages")
public class LanguagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(nullable = false, length = 30)
    private String language;

    @NotNull
    @Column(nullable = false)
    private Boolean isOfficial;

    @NotNull
    @Column(nullable = false)
    private Float percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountriesEntity country;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Boolean getIsOfficial() { return isOfficial; }
    public void setIsOfficial(Boolean isOfficial) { this.isOfficial = isOfficial; }

    public Float getPercentage() { return percentage; }
    public void setPercentage(Float percentage) { this.percentage = percentage; }

    public CountriesEntity getCountry() { return country; }
    public void setCountry(CountriesEntity country) { this.country = country; }
}
