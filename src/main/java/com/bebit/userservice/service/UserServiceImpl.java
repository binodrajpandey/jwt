package com.bebit.userservice.service;

import com.bebit.userservice.domain.AppUser;
import com.bebit.userservice.domain.Role;
import com.bebit.userservice.repo.AppUserRepo;
import com.bebit.userservice.repo.RoleRepo;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final AppUserRepo appUserRepo;
  private final RoleRepo roleRepo;

  @Override
  public AppUser saveUser(AppUser appUser) {
    log.info("Saving new user........");
    return appUserRepo.save(appUser);
  }

  @Override
  public Role saveRole(Role role) {
    log.info("Saving new Role........");
    return roleRepo.save(role);
  }

  @Override
  public void addRoleToUser(String username, String roleName) {
    log.info("Adding new role to the user......");
    AppUser appUser = appUserRepo.findByUsername(username);
    Role role = roleRepo.findByName(roleName);
    appUser.getRoles().add(role);

  }

  @Override
  public AppUser getUser(String username) {
    log.info("getting user for a given username....");
    return appUserRepo.findByUsername(username);
  }

  @Override
  public List<AppUser> getUsers() {
    log.info("Getting all the users......");
    return appUserRepo.findAll();
  }
}
