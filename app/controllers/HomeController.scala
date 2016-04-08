package controllers

import javax.inject.Inject

import play.api.libs.json.Json
import play.api.mvc._
import models.Location._

class HomeController @Inject extends Controller {

  def index = Action {
    Ok(Json.toJson(Location("1.2.3.4", "foo.bar")))
  }

}
