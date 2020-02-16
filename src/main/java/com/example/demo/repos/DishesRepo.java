package com.example.demo.repos;

import com.example.demo.domain.Dishes;
import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DishesRepo extends JpaRepository<Dishes, Long> {
    List<Dishes> findAll();

    List<Dishes> findOneById(Long id);

    Iterable<Dishes> findByName(String name);

    List<Dishes> findOneByName(String name);

    //List<Dishes> findAllByUserId(Long user_id, User user);

    //List<Dishes> findAllByIdAndUserId(Long id, Long user_id);

    //Page<Dishes> findByUserId(Long userId, Pageable pageable);

    //@Query("SELECT * FROM public.dishes WHERE user_id=:user_id")
    //Iterable<Dishes> findByUser_id(@Param("user_id") String user_id);
}
