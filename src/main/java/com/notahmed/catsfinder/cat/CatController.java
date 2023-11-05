package com.notahmed.catsfinder.cat;

import com.notahmed.catsfinder.cat.request.CatRequest;
import com.notahmed.catsfinder.cat.response.HomeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {


    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    // may add home route
    @GetMapping("")
    public ResponseEntity<?> home() {
        HomeResponse res = new HomeResponse(
               "this is the home route",
               "check out other routes"
       );

        return ResponseEntity.ok(res);
    }


    /**
     * Controller to get all cats from database
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<?> getAllCats() {

        List<Cat> cats = new ArrayList<>();

        return ResponseEntity.ok(cats);
    }


    /**
     * Controller to save cat into database
     * @param cat
     * @return
     */
    public ResponseEntity<?> createCat(@RequestBody CatRequest cat) {

        catService.save(cat);

        return ResponseEntity.ok("successfully created cat");
    }


    /**
     * Controller to update a cat by id
     * @param catId
     * @param cat
     * @return
     */
    public ResponseEntity<?> updateCat(@RequestParam Long catId, @RequestBody CatRequest cat) {

        catService.update(catId, cat);
        return ResponseEntity.ok("updated");

    }


    /**
     * Controller to delete cat by id
     * @param catId
     * @return
     */
    public ResponseEntity<?> deleteCat(@RequestParam Long catId) {
        catService.delete(catId);

        return ResponseEntity.ok("deleted");
    }


    /**
     * Controller to search for cats
     * @param q
     * @return
     */
    public ResponseEntity<?> searchCat(@RequestParam String q) {

        List<Cat> cats = catService.search(q);


        return ResponseEntity.ok(cats);
    }


}
