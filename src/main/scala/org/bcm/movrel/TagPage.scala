package org.bcm.movrel

import cats.effect.kernel.Sync
import scalatags.Text.all.*
import scalatags.Text.TypedTag

trait TagPage[F[_]] {
  def tagPage: F[TypedTag[String]]
}

object TagPage {
  def impl[F[_]: Sync](): TagPage[F] = {
    new TagPage[F] {
      override def tagPage: F[TypedTag[String]] =
        Sync[F].catchNonFatal(
          html(
            head(
              script("some script")
            ),
            body(
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
