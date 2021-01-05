package chat.bot.services

import groovy.json.JsonSlurper

class RequestHandler {
    JsonSlurper jsonSlurper = new JsonSlurper()

    def <T> T makePostCall(String url, String message, Class<T> requiredType) {
        def connection = (HttpURLConnection)new URL(url).openConnection()
        connection.setRequestMethod("POST")
        connection.setRequestProperty( "Content-Type", "application/json")
        connection.setRequestProperty( "charset", "utf-8");
        connection.setRequestProperty( "Content-Length", Integer.toString(message.bytes.length))
        connection.setDoOutput(true)
        connection.getOutputStream().write(message.getBytes("UTF-8"))
        def postCode = connection.getResponseCode()
        def result = connection.getInputStream().getText()

        return jsonSlurper.parseText(result) as T
    }

    def <T> T makeGetCall(String url, Class<T> requiredType) {
        def connection = new URL(url).openConnection()
        def result = connection.getInputStream().getText()

        return jsonSlurper.parseText(result) as T
    }
}
