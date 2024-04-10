package scalacucumberplaywright

import scala.jdk.CollectionConverters._

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

  def getAllTextFromAListOfElements(element: String): String = {
    webDriver.page.locator(element).textContent()
  }

  def elementVisibleOrNot(element: String): Boolean ={
    webDriver.page.locator(element).isVisible()
  }

  def selectFromDropdownUsingText(element: String, selectOptionInText: String): Unit ={
    webDriver.page.locator(element).selectOption(selectOptionInText)
  }

}
