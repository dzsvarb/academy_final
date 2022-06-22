package com.academy.academy_final.model.repository;

import com.academy.academy_final.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsername (String name);

}
