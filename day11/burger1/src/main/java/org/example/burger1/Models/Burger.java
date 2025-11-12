package org.example.burger1.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "burgers")

public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "should not be blank")
    private String BurgerName;
    @NotBlank
    private String RestaurantName;
    @Min(0)
    @Max(5)
    @NotNull
    private Float Rating;

            @NotBlank
    private String notes;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


    public Burger( String burgerName, String restaurantName, Float rating, String notes) {
        BurgerName = burgerName;
        RestaurantName = restaurantName;
        Rating = rating;
        this.notes = notes;
    }

    public Burger(){

    }

    public String getBurgerName() {
        return BurgerName;
    }

    public void setBurgerName(String burgerName) {
        BurgerName = burgerName;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


    @Override
    public String toString() {
        return "Burger{" +
                "Id=" + Id +
                ", BurgerName='" + BurgerName + '\'' +
                ", RestaurantName='" + RestaurantName + '\'' +
                ", Rating=" + Rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
