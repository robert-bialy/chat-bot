package chat.bot.services

import groovy.json.JsonSlurper

class JavaConnectionRequestHandler implements RequestHandler {
    private JsonSlurper jsonSlurper

    JavaConnectionRequestHandler() {
        jsonSlurper = new JsonSlurper()
    }

    def <T> T makePostCall(String url, String message, Class<T> requiredType, String token = null) {
        HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection()
        byte[] messageBytes = message.getBytes("UTF-8")
        connection.setRequestMethod("POST")
        connection.setRequestProperty( "Content-Type", "application/json")
        connection.setRequestProperty( "charset", "utf-8");
        connection.setRequestProperty( "Content-Length", Integer.toString(messageBytes.length))
        if(token != null) {
            connection.setRequestProperty("Authorization","Bearer "+ token)
        }
        connection.setDoOutput(true)

        String result
        try {
            OutputStream outputStream = connection.getOutputStream()
            outputStream.write(messageBytes)
            result = connection.getInputStream().getText()
        } catch (Exception ex) {
            println(ex.message)
            throw ex
        }
        finally {
            connection.disconnect()
        }

        return jsonSlurper.parseText(result) as T
    }

    def <T> T makeGetCall(String url, Class<T> requiredType, String token = null) {
        HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection()
        if(token != null) {
            connection.setRequestProperty("Authorization","Bearer "+ token)
        }

        String result
        try {
            result = connection.getInputStream().getText()
        } catch (Exception ex) {
            println(ex.message)
            throw ex
        } finally {
            connection.disconnect()
        }

        return jsonSlurper.parseText(result) as T
    }
}
