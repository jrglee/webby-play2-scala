package controllers

import java.net.{InetAddress, UnknownHostException}
import javax.inject.Inject

import play.api.libs.json.Json
import play.api.mvc._
import models.Location._

class HomeController @Inject extends Controller {

  def index = Action { request =>
    val ip = request.remoteAddress
    Ok(Json.toJson(Location(ip, lookupHostnameFromIp(ip))))
  }

  def lookupHostnameFromIp(ip: String): String = {
    try {
      val addr = InetAddress.getByName(ip)
      addr.getHostName
    } catch {
      case e: UnknownHostException => ip
    }
  }

}
