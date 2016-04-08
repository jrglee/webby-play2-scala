package models

import play.api.libs.json.Json

object Location {

  case class Location(ip: String, hostname: String)

  implicit val locationWrites = Json.writes[Location]

}