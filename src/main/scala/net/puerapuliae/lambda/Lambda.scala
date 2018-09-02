package net.puerapuliae.lambda

import java.io.InputStream
import java.io.OutputStream

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler

import com.github.plokhotnyuk.jsoniter_scala.macros._
import com.github.plokhotnyuk.jsoniter_scala.core._

case class Request(name: String)
case class Response(
  isBase64Encoded: Boolean = false,
  statusCode: Integer = 200,
  headers: Option[Map[String, String]] = None,
  body: String)

class Lambda extends RequestStreamHandler {
  def handleRequest(is: InputStream, os: OutputStream, context: Context): Unit = {
    implicit val codec: JsonValueCodec[Response] = JsonCodecMaker.make[Response](CodecMakerConfig())

    val response = Response(body = "Hallo")
    writeToStream(response, os, WriterConfig())
  }
}
