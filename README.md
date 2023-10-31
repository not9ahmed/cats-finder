# Cats Finder

## Purpose
The aim of the project is two develop a simple cats finder system.
The users will be able to post their cats and share cute pics of their cats.



## Requirements
* The system should store the info about the users.
* The system should allow to store their cats details.
* The user should be able to register in the system.
* The users should be able to updates his details.
* The admin user should be able to delete user from the system.


## Routes
| Endpoint              | HTTP Method | response                                                |
|-----------------------|-------------|---------------------------------------------------------|
| `/`                   | GET         | Get home route with welcome message                     |
| `/users`              | GET         | responds with users home page                           |
| `/users/:id`          | PUT         | updates the user details responds with updated user     |
| `/users/:id`          | DELETE      | deletes an existing user                                |
| `/users/:userId/cats` | GET         | (no need) responds with all the users cats              |                                        
| `/cats`               | GET         | responds with all cats                                  |
| `/cats`               | POST        | creates a single user                                   |
| `/cats/:id`           | GET         | responds with one cat with particular id specified      |
| `/cats/:id`           | PUT         | updates one cat with particular id specified            |
| `/cats/:id`           | DELETE      | deletes one cat with particular id specified            |
| `/breeds`             | GET         | responds with all the breeds of cats                    |
| `/breeds`             | POST        | creates a new cat breed                                 |
| `/breeds/:id`         | GET         | responds with the complete details of breed from the id |
| `/breeds/:id`         | PUT         | updates single cat using the id                         |
| `/breeds/:id`         | DELETE      | deletes one breed with particular id specified          |