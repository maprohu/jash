package jash

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Tcp
import com.typesafe.config.ConfigFactory

/**
  * Created by martonpapp on 24/08/16.
  */
object RunJashServer {

  def main(args: Array[String]): Unit = {

    implicit val actorSystem = ActorSystem(
      "jash-server",
      ConfigFactory.parseString(
        """
          |akka {
          |  extensions = ["com.romix.akka.serialization.kryo.KryoSerializationExtension$"]
          |}
        """.stripMargin
      ).withFallback(ConfigFactory.load())
    )
    implicit val materializer = ActorMaterializer()



//    Tcp().bindAndHandle(
//      ???,
//      "0.0.0.0",
//      7721
//    )


  }

}
