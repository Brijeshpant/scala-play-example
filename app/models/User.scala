package models

import play.api.libs.json._

case class User(id: String, name: String, age: Int)

object User {
  implicit val userFormats = Json.format[User]

  def write(user: User) = {
    Json.toJson(user)
  }

  def read(json: JsValue) = {
    json.as[User]
  }
}
