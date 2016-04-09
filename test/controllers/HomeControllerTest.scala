package controllers

import org.scalatestplus.play.PlaySpec
import play.api.mvc.{AnyContentAsEmpty, Results}
import play.api.test.Helpers._
import play.api.test._

class HomeControllerTest extends PlaySpec with Results {

  val controller = new HomeController()

  "HomeController#index" should {
    "should get host address" in {
      val result = controller.index.apply(FakeRequest())

      status(result) mustEqual OK
      (contentAsJson(result) \ "hostname").as[String] mustEqual "localhost"
      (contentAsJson(result) \ "ip").as[String] mustEqual "127.0.0.1"
    }

    "should return ip when there is no host" in {
      val result = controller.index.apply(FakeRequest(GET, "/", FakeHeaders(), AnyContentAsEmpty, "127.0.0.2"))

      status(result) mustEqual OK
      (contentAsJson(result) \ "hostname").as[String] mustEqual "127.0.0.2"
      (contentAsJson(result) \ "ip").as[String] mustEqual "127.0.0.2"
    }
  }
}
