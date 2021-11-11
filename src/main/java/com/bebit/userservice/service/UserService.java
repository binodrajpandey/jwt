package com.bebit.userservice.service;

import com.bebit.userservice.domain.AppUser;
import com.bebit.userservice.domain.Role;
import java.util.List;

public interface UserService {

  AppUser saveUser(AppUser appUser);

  Role saveRole(Role role);

  void addRoleToUser(String username, String roleName);

  AppUser getUser(String username);

  List<AppUser> getUsers();

}
