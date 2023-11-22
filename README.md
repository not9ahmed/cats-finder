# Cats Finder

## Purpose
The aim of the project is two develop a simple cats finder system.
The users will be able to post their cats and share cute pics of their cats.


## User Stories
* The user can create a new account with username, password, and add additional details such email, name, etc.
* User must sign in to the system to receive a token to indicate his authentication, and authorization.
* User can edit his details and update the necessary details.
* The user can delete his account from the system.
* 
* User can add his cats with their name, description, images and choose the breed, and also the system can help in identifying the cat breed (Machine Learning).
* User can update and delete his cats from the system.
* User must have the ability to add some comments about their cat.
* 

* 
* The admin user can create new cat breeds with the necessary information such as breed name, origin country, fun facts and images.
* The admin user can update and delete breeds from the system when required.
* Admin user can delete users from the system and disable them.
* 
*
* The user can create a new post with their cat with new and full content with images.
* Users can also update their cats' post and have the option to delete.
* Other user can browse through the system and find posts of cat breeds which they like.
*


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
| `/users`              | GET         | responds with all the users                             |
| `/users`              | POST        | creates a new user                                      |
| `/users/:id`          | PUT         | gets single user details using their id                 |
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
| `/blog`               | GET         | responses with all the blogs                            |