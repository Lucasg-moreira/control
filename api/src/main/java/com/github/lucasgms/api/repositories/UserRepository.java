package com.github.lucasgms.api.repositories;

import com.github.lucasgms.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(@Param("name") String name);
    User findByEmail(@Param("email") String email);
}