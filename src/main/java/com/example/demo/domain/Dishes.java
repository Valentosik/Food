package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String composition;
    private String nutrients;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Dishes() {

    }

    public Dishes(String name, String composition, String nutrients, User user) {
        this.author = user;
        this.name = name;
        this.composition = composition;
        this.nutrients = nutrients;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
