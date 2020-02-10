package com.example.demo.domain;






import javax.persistence.*;

@Entity
@Table(name = "DailyMeal")
public class DailyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
