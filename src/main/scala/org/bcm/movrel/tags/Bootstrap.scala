package org.bcm.movrel.tags

import scalatags.Text.all.*

object Bootstrap {
  // Elements
  lazy val nav: ConcreteHtmlTag[String] = tag("nav")

  // Attributes
  lazy val ariaCurrent: Attr = attr("aria-current")
  lazy val dataBsTheme: Attr = attr("data-bs-theme")
}
