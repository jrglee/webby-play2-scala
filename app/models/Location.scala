package models

import play.api.libs.json.Json

object Location {
  implicit val locationWrites = Json.writes[Location]
}

case class Location(ip: String, hostname: String)