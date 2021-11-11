package com.bebit.userservice.repo;

import com.bebit.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

  Role findByName(String name);

}
