package controllers

import javax.inject._

import config.DbConfig
import play.api._
import play.api.mvc._

/**
  * Example for reading configuration from application config
  * including other configuration
  */
@Singleton
class HomeController @Inject()(config: Configuration, cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val logFile = config.get[String]("loggers.log-file")
    val dbConfig = config.get[DbConfig]("db.config")
    val dbName = dbConfig.name
    val password = dbConfig.password
    Ok(config.get[String]("app.name"))
  }
}
