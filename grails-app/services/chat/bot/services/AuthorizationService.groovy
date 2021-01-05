package chat.bot.services

import chat.bot.authorization.AuthorizationMessage
import chat.bot.config.Constants

class AuthorizationService {
    RequestHandler requestHandler = new RequestHandler()

    AuthorizationMessage getToken() {
        return requestHandler.makePostCall(Constants.ApiUrl + '/login', '{"username": "chat_bot", "password": "chat_bot_password"}', AuthorizationMessage.class)
    }
}
