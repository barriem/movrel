package org.bcm.movrel

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run = MovrelServer.run[IO]
