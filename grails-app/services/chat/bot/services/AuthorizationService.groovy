package chat.bot.services

import chat.bot.authorization.AuthorizationMessage
import chat.bot.config.Constants

class AuthorizationService {
    final RequestHandler requestHandler
    AuthorizationService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }

    AuthorizationMessage getToken() {
        return requestHandler.makePostCall(Constants.ApiUrl + '/login', '{"username": "chat_bot", "password": "chat_bot_password"}', AuthorizationMessage.class)
    }
}
