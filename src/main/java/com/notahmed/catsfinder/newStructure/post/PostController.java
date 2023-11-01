package com.notahmed.catsfinder.newStructure.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    /**
     * route to fetch all the posts
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts() {

        List<Post> posts = new ArrayList<>();
        return ResponseEntity.ok(posts);
    }


    @PostMapping("/")
    public ResponseEntity<String> createPost() {



        return ResponseEntity.ok("create successfully");
    }


}
