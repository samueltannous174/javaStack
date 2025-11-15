package org.example.dojos_ninjas.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ninjas")

public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private  String first_name;
    @NotBlank
    private String last_name;
    @NotNull(message="Age is required")
    @Min(value = 1, message="Age must be at least 1")
    private Integer age;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dojo_id")
    private Dojo dojo;


    public Ninja(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Ninja() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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

    public Dojo getDojo() {
        System.out.println(dojo);
        return dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", dojo=" + (dojo != null ? dojo.getId() : "null") +
                '}';
    }

}
