package jash

import akka.stream.scaladsl.{Flow, Framing}
import akka.util.ByteString

import scala.collection.immutable._

/**
  * Created by martonpapp on 24/08/16.
  */
object JashProtocol {

  val MaxMessageSize = 1024 * 16

  val framing = Framing.simpleFramingProtocol(MaxMessageSize)


  val flow =
    Flow[ByteString]
      .prefixAndTail(1)
      .flatMapConcat({
        case (Seq(msg), rest) =>
          rest
      })


}

case class JarHash(
  hash: Array[Byte]
)

case class ClassHierarchy(
  jars: Seq[JarHash],
  parent: Option[ClassHierarchy]
)

case class RequestJars(
  jars: Seq[JarHash]
)

