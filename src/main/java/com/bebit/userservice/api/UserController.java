package com.bebit.userservice.api;

import com.bebit.userservice.domain.AppUser;
import com.bebit.userservice.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<AppUser>> getALlUsers() {
    return ResponseEntity.ok().body(userService.getUsers());
  }

}
