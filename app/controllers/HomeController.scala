package controllers

import java.net.InetAddress
import javax.inject.Inject

import models.Location._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class HomeController @Inject extends Controller {

  def index = Action.async { request =>
    val ip = request.remoteAddress
    lookupHostnameFromIp(ip) map (hostname => Ok(Json.toJson(Location(ip, hostname))))
  }

  def lookupHostnameFromIp(ip: String) = {
    Future(InetAddress.getByName(ip).getHostName) andThen {
      case Success(hostname) => hostname
      case Failure(_) => ip
    }
  }
}
