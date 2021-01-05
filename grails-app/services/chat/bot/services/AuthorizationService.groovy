package chat.bot.services

import chat.bot.AuthorizationMessage

class AuthorizationService {
    RequestHandler requestHandler = new RequestHandler()

    AuthorizationMessage getToken() {
        return requestHandler.makePostCall(Config.ApiUrl + '/login', '{"username": "chat_bot", "password": "chat_bot_password"}', AuthorizationMessage.class)
    }
}
