package com.course5i.base.framework.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course5i.base.framework.entity.UserDetailsEntity;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
	public Optional<UserDetailsEntity> findByUsername(String username);
	Boolean existsByUsername(String username);
	  Boolean existsByEmail(String email);
}
