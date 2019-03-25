package dataInserter

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main(args: Array<String>) {
    val url = URL("http://localhost:8080/shipments")
    val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

    urlConnection.setRequestProperty("content-type", "application/json")
    urlConnection.requestMethod = "POST"

    try {
        urlConnection.doOutput = true
        urlConnection.doInput = true

        val shipment = """{ "destination": "The" }"""
        val outputStream = urlConnection.outputStream

        outputStream.write(shipment.toByteArray())
        outputStream.flush()
        outputStream.close()

        val inputStream = urlConnection.inputStream
        BufferedReader(InputStreamReader(inputStream)).lines().forEach { println(it) }
        inputStream.close()

        urlConnection.disconnect()
    } catch (e: Exception) {
        println(e.message)
    }
}