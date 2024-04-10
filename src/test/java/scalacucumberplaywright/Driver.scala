package scalacucumberplaywright

import java.util

class Driver {

  def loadAURL(url: String): Unit ={
    webDriver.page.navigate(url)
  }

  def typeText(textToType: String, element: String): Unit ={
    webDriver.page.locator(element).fill(textToType)
  }

  def clickButton(element: String): Unit ={
    webDriver.page.locator(element).click()
  }

  def getTextFromElement(element: String): String ={
    webDriver.page.locator(element).textContent()
  }

  def getSpecificTextFromAListOfElements(element: String, index: Int): String ={
    webDriver.page.locator(element).nth(index).textContent()
  }

  def getAllTextFromAListOfElements(element: String): util.List[String] = {
    webDriver.page.locator(element).allTextContents()
  }

  def elementVisibleOrNot(element: String): Boolean ={
    webDriver.page.locator(element).isVisible()
  }

  def selectFromDropdownUsingText(element: String, selectOptionInText: String): Unit ={
    webDriver.page.locator(element).selectOption(selectOptionInText)
  }

  def getTheCurrentURL: String ={
    webDriver.page.url()
  }

  def getURLFromANewTab(toBeExecuted: Unit): String = {
    webDriver.page.waitForPopup(() =>
    toBeExecuted
    ).url()
  }
  webDriver.page.bringToFront()
}
