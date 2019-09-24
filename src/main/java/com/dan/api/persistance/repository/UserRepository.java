package com.dan.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan.api.persistance.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
