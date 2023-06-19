# Cats Finder

## Purpose
The aim of the project is two develop a simple cats finder system.
The users will be able to post their cats and share cute pics of their cats.



## Requirements
* The system should store the info about the users.
* The system should allow to store their cats details.


## Routes
| Endpoint         | HTTP Method | response                                            |
|------------------|-------------|-----------------------------------------------------|
| `/`              | GET         | Get Home Page                                       |
| `/users`         | GET         | responds with users home page                       |
| `/users/id`      | PUT         | updates the user details responds with updated user |
| `/cats`          | GET         | responds withs all cats                             |
| `/users/id/cats` | GET         | responds with the users cats                        |

