package scalacucumberplaywright

import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.Assert._

class Steps_Footer extends ScalaDsl with EN {

  val driverMethods = new Driver
  val configs = new Configs
  val selectors = new Selectors

  Given("""I confirm that the footer is {string}"""){ (visibleStatus: String) =>
    if(visibleStatus == "not visible"){
      assertFalse(driverMethods.elementVisibleOrNot(selectors.footer))
    }
    else {
      assertTrue(driverMethods.elementVisibleOrNot(selectors.footer))
    }
  }

  And("""the {string} icon in the footer should open {string}""") { (footerIcon: String, redirectURL: String) =>
    footerIcon match {
      case "Twitter" =>
        val newURL = driverMethods.getURLFromANewTab(driverMethods.clickButton(selectors.footerTwitter))
        assertEquals(newURL, redirectURL)
      case "Facebook" =>
        val newURL = driverMethods.getURLFromANewTab(driverMethods.clickButton(selectors.footerFacebook))
        assertEquals(newURL, redirectURL)
      case "LinkedIn" =>
        val newURL = driverMethods.getURLFromANewTab(driverMethods.clickButton(selectors.footerLinkedin))
        assertEquals(newURL, redirectURL)
      case _ =>
        throw new IllegalArgumentException("Incorrect Footer icon : " + footerIcon)
    }
    Thread.sleep(5000)
  }

}
