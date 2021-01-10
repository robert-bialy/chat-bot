package chat.bot.services

import chat.bot.authorization.AuthorizationMessage
import chat.bot.config.Constants
import org.apache.logging.log4j.Level

import java.util.logging.Logger

class AuthorizationService {
    final RequestHandler requestHandler
    final Logger logger = Logger.getLogger("AuthorizationService")
    AuthorizationService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }

    AuthorizationMessage getToken() {
        try {
            String url = Constants.ApiUrl + '/login'
            String payload = String.format('{"username": "%s", "password": "%s"}', Constants.GoogleTrendsApiUser, Constants.GoogleTrendsApiPassword)

            return requestHandler.makePostCall(url, payload, AuthorizationMessage.class)
        } catch (Exception ex) {
            logger.log(Level.ERROR, ex.message)
            return null
        }
    }
}
