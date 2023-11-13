package com.notahmed.catsfinder.breed;

import com.notahmed.catsfinder.breed.request.BreedRequest;
import com.notahmed.catsfinder.breed.response.BreedResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/breeds")
public class BreedController {


    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }


    // what happens to route /breeds ?
    @GetMapping("")
    public ResponseEntity<String> home() {

        // add list of endpoints here

        return ResponseEntity.ok("Home Route");
    }



    @GetMapping("/")
    public ResponseEntity<List<Breed>> getAllBreeds() {

        List<Breed> breeds = new ArrayList<>();

        breeds.add(new Breed(
                19L,
                "himmie",
                "cute cat",
                null
        ));

        return ResponseEntity.ok(breeds);
    }



    @GetMapping("/{id}")
    public ResponseEntity<BreedResponse> findBreedById(@PathVariable Long id) {


        ResponseEntity<BreedResponse> breed = breedService.findById(id);

        return breed;
    }


    @PostMapping("/")
    public ResponseEntity<String> createBreed() {

        return ResponseEntity.ok("Successfully created");
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateBreedById(@PathVariable Long id, @RequestBody BreedRequest breed) {

        // TODO: call service to update the breed

        return ResponseEntity.ok("Successfully updated");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBreedById(@PathVariable Long id) {

        return ResponseEntity.ok("Successfully deleted");
    }



    @GetMapping("")
    public ResponseEntity<List<BreedResponse>> searchBreeds(@RequestParam String q) {

        ResponseEntity<List<BreedResponse>> breedsList = breedService.searchBreeds(q);




        return breedsList;
    }



    @GetMapping("")
    public ResponseEntity<List<BreedResponse>> searchBreedsWithFields(@RequestParam(required = false) String name,
                                                                      @RequestParam(required = false) String origin) {

        // call the service to search based on the provided params

        // get the breeds list

        // map it to BreedResponse dto


        // add the correct api code


        return null;
    }


}
