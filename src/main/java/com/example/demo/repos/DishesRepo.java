package com.example.demo.repos;

import com.example.demo.domain.Dishes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DishesRepo extends CrudRepository<Dishes, Long> {
    List<Dishes> findAll();

    List<Dishes> findOneById(Long id);

    Iterable<Dishes> findByName(String name);

    List<Dishes> findOneByName(String name);

    //Iterable<Dishes> findByUser_id(String user_id);

    //@Query("SELECT * FROM public.dishes WHERE user_id=:user_id")
    //Iterable<Dishes> findByUser_id(@Param("user_id") String user_id);
}
