package com.notahmed.catsfinder.examples;

import com.notahmed.catsfinder.model.User;
import com.notahmed.catsfinder.repository.template.UserJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/example")
public class ExampleController {


    private final UserJdbcTemplate userJdbcTemplate;

    public ExampleController(UserJdbcTemplate userJdbcTemplate) {
        this.userJdbcTemplate = userJdbcTemplate;
    }


    record Person(
            int id,
            String name
    ){ }

    @GetMapping("")
    @ResponseBody
    public Person example(@RequestParam int id, @RequestParam String name){



        Person context = new Person(id, name);

//        message = "The id is "+id + " and name is "+name;
        return context;
    }


    record Response (
            String id,
            String name,
            String extra
    ){}

    @PostMapping("")
    @ResponseBody
    public Response addFoo(@RequestParam( name = "id") Optional<String> fooId, @RequestParam String name,
                         @RequestParam(defaultValue = "empty") String extra) {

        String foo = fooId.orElseGet(()->"Not provided");


        return new Response(
                fooId.orElseGet(()->"Not provided"),
                name,
                extra
                );
    }


    record Response1(
            String id,
            String name
    ){}

    @GetMapping("/foos")
    public Response1 getFoos(@RequestParam(required = false) String id){


        if(id == null){
            return new Response1(null, null);
        }
        return new Response1(id,null);
    }


    record Foos(

    ){}


    @GetMapping("/params")
    public Map<String, String> getFoos(@RequestParam Map<String, String> allParams){


        System.out.println("key set");
        System.out.println(allParams.keySet());

        System.out.println("entry set");
        System.out.println(allParams.entrySet());


        System.out.println("values");
        System.out.println(allParams.values());



        return allParams;
//        return "All Parameters"+ allParams.entrySet();
    }



    @GetMapping("/multiparams")
    public List<String> getMultiFoos(@RequestParam(name = "id") List<String> ids){


        System.out.println(ids);
        return ids;

    }

    @GetMapping("/jdbc")
    public List<User> getAllUsers(){
        return userJdbcTemplate.findAllUsers();
    }



}
