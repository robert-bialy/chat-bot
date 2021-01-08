package chat.bot.services

import groovy.json.JsonSlurper

class JavaConnectionRequestHandler implements RequestHandler {
    private JsonSlurper jsonSlurper

    JavaConnectionRequestHandler() {
        jsonSlurper = new JsonSlurper()
    }

    def <T> T makePostCall(String url, String message, Class<T> requiredType, String token = null) {
        def connection = (HttpURLConnection)new URL(url).openConnection()
        connection.setRequestMethod("POST")
        connection.setRequestProperty( "Content-Type", "application/json")
        connection.setRequestProperty( "charset", "utf-8");
        connection.setRequestProperty( "Content-Length", Integer.toString(message.bytes.length))
        if(token != null) {
            connection.setRequestProperty("Authorization","Bearer "+ token)
        }
        connection.setDoOutput(true)
        connection.getOutputStream().write(message.getBytes("UTF-8"))
        def result = connection.getInputStream().getText()

        return jsonSlurper.parseText(result) as T
    }

    def <T> T makeGetCall(String url, Class<T> requiredType, String token = null) {
        def connection = new URL(url).openConnection()
        if(token != null) {
            connection.setRequestProperty("Authorization","Bearer "+ token)
        }
        def result = connection.getInputStream().getText()

        return jsonSlurper.parseText(result) as T
    }
}
