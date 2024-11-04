package org.bcm.movrel

import cats.effect.Async
import com.comcast.ip4s.*
import fs2.io.net.Network
import org.bcm.movrel.pages.Home
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits.*
import org.http4s.server.middleware.Logger

object MovrelServer {
  def run[F[_]: Async: Network]: F[Nothing] = {
    for {
      client <- EmberClientBuilder.default[F].build
      homePageAlg  = Home.impl[F]()
      httpApp      = MovrelRoutes.tagPageRoute(homePageAlg).orNotFound
      finalHttpApp = Logger.httpApp(true, true)(httpApp)
      _ <-
        EmberServerBuilder
          .default[F]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(finalHttpApp)
          .build
    } yield ()
  }.useForever
}
