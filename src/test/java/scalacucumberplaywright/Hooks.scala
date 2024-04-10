package scalacucumberplaywright

import com.microsoft.playwright.Page
import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import scalacucumberplaywright.webDriver.page

object webDriver {
  var page: Page = _
}

class Hooks extends ScalaDsl with EN {

  Before { (_: Scenario) =>
    System.out.print("Starting before hook")
    val playwright = Playwright.create
    val browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
    page = browser.newPage
  }

  After { (scenario: Scenario) =>
    scenario.attach(page.screenshot, "image/png", "image1")
    page.close()
  }

}
