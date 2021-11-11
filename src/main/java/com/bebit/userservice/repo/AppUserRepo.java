package com.bebit.userservice.repo;

import com.bebit.userservice.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

  AppUser findByUsername(String username);

}
