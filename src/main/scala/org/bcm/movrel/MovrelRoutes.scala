package org.bcm.movrel

import cats.effect.Sync
import cats.syntax.all.*
import org.http4s.dsl.Http4sDsl
import org.http4s.scalatags.*
import org.http4s.HttpRoutes

object MovrelRoutes:

  def jokeRoutes[F[_]: Sync](J: Jokes[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl.*
    HttpRoutes.of[F] { case GET -> Root / "joke" =>
      for {
        joke <- J.get
        resp <- Ok(joke)
      } yield resp
    }

  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl.*
    HttpRoutes.of[F] { case GET -> Root / "hello" / name =>
      for {
        greeting <- H.hello(HelloWorld.Name(name))
        resp     <- Ok(greeting)
      } yield resp
    }

  def tagPageRoute[F[_]: Sync](T: TagPage[F]): HttpRoutes[F] =
    val dsl = new Http4sDsl[F] {}
    import dsl.*
    HttpRoutes.of[F] { case GET -> Root / "tagpage" =>
      for {
        page <- T.tagPage
        resp <- Ok(page)
      } yield resp
    }
