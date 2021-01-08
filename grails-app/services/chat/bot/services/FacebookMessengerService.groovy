package chat.bot.services

import chat.bot.config.Constants
import chat.bot.facebookMessages.RequestMessage
import groovy.json.JsonBuilder

class ResponseMessage {
    ResponseMessage(String senderId, String message) {
        this.recipient = new HashMap<>()
        this.message = new HashMap<>()
        this.recipient.put("id", senderId)
        this.message.put("text", message)
    }

    final String messaging_type = "RESPONSE"
    Map<String, String>  recipient
    Map<String, String> message
}

class FacebookMessengerService implements MessengerService {
    final RequestHandler requestHandler

    FacebookMessengerService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }

    def SendMessage(String senderId, String message) {
        def json = new JsonBuilder(new ResponseMessage(senderId, message)).toPrettyString()
        requestHandler.makePostCall(Constants.MessengerEndpoint + '?access_token=' + Constants.AccessToken, json,  RequestMessage.class)
    }
}
