package com.dan.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dan.api.persistance.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	
	@Query("select u from User u where (u.username = ?1 or u.email = ?2) and u.password = ?3")
	public User authenticateUser(String username, String email, String password);
}
