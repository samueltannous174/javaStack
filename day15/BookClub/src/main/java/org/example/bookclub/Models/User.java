package org.example.bookclub.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Name is required!")
    @Size(min = 3, message = "Name must be more than 3 characters")
    private String name;

    @NotBlank(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;

    @NotBlank(message="Password is required!")
    @Size(min =8, message = "Password must be more than 3 characters")
    private String password;

    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min = 8, message = "Password must be more than 8 characters")
    private String confirm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="Birthday is required!")
    private LocalDate birthday;


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String name, String email, String password, String confirm, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                '}';
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}

