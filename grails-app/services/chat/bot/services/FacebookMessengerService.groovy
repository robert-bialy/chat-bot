package chat.bot.services

import chat.bot.config.Constants
import chat.bot.facebookMessages.RequestMessage
import groovy.json.JsonBuilder
import org.apache.logging.log4j.Level

import java.util.logging.Logger

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
    final Logger logger = Logger.getLogger("FacebookMessengerService")

    FacebookMessengerService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }

    def SendMessage(String senderId, String message) {
        ResponseMessage responseMessage = new ResponseMessage(senderId, message)
        String json = new JsonBuilder(responseMessage).toPrettyString()
        String url = Constants.MessengerEndpoint + '?access_token=' + Constants.AccessToken

        try {
            requestHandler.makePostCall(url, json,  RequestMessage.class)
        } catch (Exception ex) {
            logger.log(Level.ERROR, ex.message)
            return null
        }
    }
}
