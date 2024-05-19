package com.springsecuritygfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecuritygfg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

    User findByAuthority(String authority);

}
