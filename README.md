# scala-play-example
This branch has some examples to show case how to define routes for different http methods like POST, PUT, GET
and it also show case handling of path params, query params and json payload.
You will also see how to serialize and deserialize json objects


#### UserController 
   Define actions for creating user, updating user, retrieve user, retrieve all users and search users by there name and age
     
### User 
   Domain class define user
### User object 
      User object provides implicit format for user to serialize and deserialize User.
     When play action receives request, It tries to convert request body json object to User (request.body.asJson.get.as[User]).
      It requires reader of User type . which we tried to provide via PROVIDING implicit READERR for type User.
      Similerly for sending response we have json writer of type User 
         
  
### UserService 
   Cache to store users

## Routes
####  Create new user 
     curl -i \
         -H "Content-Type: application/json" \
          -X POST -d '{"id" :"3","name": "Brij","age": 30}' http://localhost:9000/user/create
#### update user           
          curl -i \
           -H "Content-Type: application/json" \
            -X PUT -d '{"id" :"3","name": "Jay","age": 25}' http://localhost:9000/user/create   
#### Get user by id
     curl http://localhost:9000/user/1
#### Get all users
     curl http://localhost:9000/users 
        
#### Search user by name and age
    curl http://localhost:9000/users/search?name="Brij"&& age=20

 