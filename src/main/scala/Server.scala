package com.blikk.boilerpipeapi

import akka.actor._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json._
import spray.json.DefaultJsonProtocol._
import de.l3s.boilerpipe.extractors.ArticleExtractor

object Server extends App {
  implicit val system = ActorSystem()
  import system.dispatcher
  implicit val materializer = ActorMaterializer()

  case class ExtractionRequest(
    html: Option[String],
    url: Option[String]
  )
  implicit val _ = jsonFormat2(ExtractionRequest)

  val routes =
    path("extract") {
      post { decodeRequest { entity(as[ExtractionRequest]) { req =>
        val extractor = ArticleExtractor.getInstance()
        req match {
          case ExtractionRequest(Some(html), _) => complete { extractor.getText(html) }
          case ExtractionRequest(None, Some(url)) => complete { extractor.getText(new java.net.URL(url)) }
        }
      }}}
    }

  val port = Option(sys.env("PORT")).getOrElse("3000").toInt
  val bindingFuture = Http().bindAndHandle(routes, "0.0.0.0", port)
  system.awaitTermination()
}
