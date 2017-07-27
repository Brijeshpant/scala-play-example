package controllers

import javax.inject._

import models.User
import models.User.userFormats
import play.api.libs.json.Json
import play.api.mvc._
import services.UserService

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def createUser() = Action { implicit request: Request[AnyContent] =>
    val user = request.body.asJson.get.as[User]
    UserService.addUser(user)
    Created(s"user with name ${user.name} successfully created")
  }

  def updateUser(userId: String) = Action { implicit request: Request[AnyContent] =>
    val user = request.body.asJson.get.as[User]
    UserService.updateUser(userId, user)
    Ok(s"user ${user.name} successfully updated")
  }

  def getUser(userId: String) = Action { implicit request: Request[AnyContent] =>
    UserService.getUser(userId).map(user => Ok(Json.toJson(user))).getOrElse(NotFound(s"user with id ${userId} does not exists"))
  }

  def getUsers() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(UserService.users.values))
  }

  def search(name: Option[String], age: Option[Int]) = Action { implicit request: Request[AnyContent] =>
    val users = UserService.users.collect { case (_, user) if (user.name.contains(name.getOrElse(user.name)) && user.age == age.getOrElse(user.age)) => user }
    Ok(Json.toJson(users))
  }
}
