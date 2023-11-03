package com.notahmed.catsfinder.cat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    // get from the original but clean it up
    @GetMapping("/")
    public ResponseEntity<List<Cat>> getAllCats() {

        List<Cat> cats = new ArrayList<>();

        return ResponseEntity.ok(cats);
    }

}
