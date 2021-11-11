package com.bebit.userservice.api;

import com.bebit.userservice.domain.AppUser;
import com.bebit.userservice.domain.Role;
import com.bebit.userservice.service.UserService;
import java.net.URI;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<AppUser>> getALlUsers() {
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @PostMapping("/user/save")
  public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
    URI uri = URI.create(
        ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
    return ResponseEntity.created(uri).body(userService.saveUser(appUser));
  }

  @GetMapping("/role/save")
  public ResponseEntity<Role> saveRole(@RequestBody Role role) {
    URI uri = URI.create(
        ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

    return ResponseEntity.created(uri).body(userService.saveRole(role));
  }

  @GetMapping("/role/addtouser")
  public ResponseEntity<List<AppUser>> addRoleToUser(
      @RequestBody RoleToAppUserForm roleToAppUserForm) {
    userService.addRoleToUser(roleToAppUserForm.getUsername(), roleToAppUserForm.getRoleName());
    return ResponseEntity.ok().build();
  }

  @GetMapping("/user/{username}")
  public ResponseEntity<AppUser> getUser(@PathVariable String username) {
    return ResponseEntity.ok().body(userService.getUser(username));
  }

}

@Data
class RoleToAppUserForm {

  private String username;
  private String roleName;
}
