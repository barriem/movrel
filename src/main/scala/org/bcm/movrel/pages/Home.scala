package org.bcm.movrel.pages

import cats.effect.kernel.Sync
import org.bcm.movrel.tags.Bootstrap.*
import scalatags.Text.all.*
import scalatags.Text.TypedTag

trait Home[F[_]] {
  def home: F[TypedTag[String]]
}

object Home {
  def impl[F[_]: Sync](): Home[F] = {
    new Home[F] {
      override def home: F[TypedTag[String]] =
        Sync[F].catchNonFatal(
          html(
            head(
              link(
                href := "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css",
                rel  := "stylesheet"
              )
            ),
            body(
              nav(
                cls         := "navbar navbar-expand-lg bg-body-tertiary",
                dataBsTheme := "dark",
                div(
                  cls := "container-fluid",
                  a(
                    "Movrel",
                    href := "#",
                    cls  := "navbar-brand"
                  ),
                  div(
                    cls := "collapse navbar-collapse",
                    ul(
                      cls := "navbar-nav",
                      li(
                        cls := "nav-item",
                        a(
                          "Home",
                          cls         := "nav-link active",
                          href        := "#",
                          ariaCurrent := "page"
                        )
                      ),
                      li(
                        cls := "nav-item",
                        a(
                          "Stuff",
                          cls  := "nav-link",
                          href := "#"
                        )
                      )
                    )
                  )
                )
              ),
              h1("This is my title"),
              div(
                p("This is my first paragraph"),
                p("This is my second paragraph")
              )
            )
          )
        )
    }
  }
}
