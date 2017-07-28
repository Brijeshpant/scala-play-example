package config

import com.typesafe.config.Config
import play.api.ConfigLoader

/**
  * Created by bpant on 28/07/17.
  */

case class DbConfig(name: String, user: String, password: String, port: Int)

object DbConfig {
  implicit val configLoader: ConfigLoader[DbConfig] = new ConfigLoader[DbConfig] {
    def load(rootConfig: Config, path: String): DbConfig = {
      val config = rootConfig.getConfig(path)
      val dbName = config.getString("db.name")
      val user = config.getString("db.user")
      val password = config.getString("db.password")
      val port = config.getInt("db.port")
      DbConfig(dbName, user, password, port)
    }
  }
}
