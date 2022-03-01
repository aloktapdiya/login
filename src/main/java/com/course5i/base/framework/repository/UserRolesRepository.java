package com.course5i.base.framework.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course5i.base.framework.entity.UserRolesEntity;
import com.course5i.base.framework.model.MyUserDetails;
import com.course5i.base.framework.model.UserRole.EnumRole;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {

	
	Optional <UserRolesEntity> findByName(String name);

	Optional<UserRolesEntity> findByName(EnumRole roleUser);

	void save(MyUserDetails user);

}
