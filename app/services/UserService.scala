package services

import models.User
import scala.collection.mutable.Map

object UserService {
  val users: Map[String, User] = Map.empty[String, User]

  def addUser(user: User) = {
    users += (user.id -> user)
  }

  def updateUser(id: String, user: User) = {
    users(id) = user
  }

  def getUser(id: String) = {
    users.get(id)
  }
}
