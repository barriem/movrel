package org.bcm.movrel

import cats.effect.Sync
import cats.syntax.all.*
import org.bcm.movrel.pages.Home
import org.http4s.dsl.Http4sDsl
import org.http4s.scalatags.*
import org.http4s.HttpRoutes

object MovrelRoutes {
  def tagPageRoute[F[_]: Sync](H: Home[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl.*
    HttpRoutes.of[F] { case GET -> Root =>
      for {
        page <- H.home
        resp <- Ok(page)
      } yield resp
    }
}
