package com.notahmed.catsfinder.user;

import com.notahmed.catsfinder.user.request.UserRequest;
import com.notahmed.catsfinder.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @GetMapping("")
//    public ResponseEntity<String> home()  {
//        return ResponseEntity.ok("Home Route");
//    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {

        ResponseEntity<List<User>> allUsers = userService.findAll();

        return allUsers;
    }


    // useful for profile page
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {

        ResponseEntity<User> user = userService.findById(id);

        return ResponseEntity.ok(null);
    }


    // useful for profile page
    @GetMapping("")
    public ResponseEntity<UserResponse> findUserByUsername(@RequestParam String username) {

        ResponseEntity<User> user = userService.findByUsername(username);

        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {

        // call service to update the user

        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {

        // call service to delete user

        return ResponseEntity.ok(null);
    }

}
