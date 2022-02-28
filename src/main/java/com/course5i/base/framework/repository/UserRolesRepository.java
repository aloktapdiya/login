package com.course5i.base.framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course5i.base.framework.entity.UserRolesEntity;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {

}
