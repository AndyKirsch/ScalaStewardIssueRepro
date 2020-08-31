import sbt._
import scala.language.postfixOps

object Dependencies {

  object Ext {

    /**
     * @see https://netty.io/wiki/new-and-noteworthy-in-4.0.html and https://mvnrepository.com/artifact/io.netty/netty-all/4.0.56.Final
     *      for (hopefully) complete list of all Netty artifacts.
     */
    object netty {

      private val version = "4.0.51.Final"
      private val buffer: ModuleID = "io.netty" % "netty-buffer" % version
      private val codec: ModuleID = "io.netty" % "netty-codec" % version
      private val common: ModuleID = "io.netty" % "netty-common" % version
      private val handler: ModuleID = "io.netty" % "netty-handler" % version

      /**
       * Netty provides some native transports that "add features specific to a particular platform, generate less
       * garbage, and generally improve performance when compared to the NIO based transport."
       *
       * @see https://netty.io/wiki/native-transports.html
       */
      object transport {

        private val base: ModuleID = "io.netty" % "netty-transport" % version
        private val linux: ModuleID = "io.netty" % "netty-transport-native-epoll" % version classifier "linux-x86_64"
        val all: Seq[ModuleID] = Seq(base, linux)
      }

      val all: Seq[ModuleID] = Seq(buffer, codec, common, handler) ++ transport.all
    }

  }
}
