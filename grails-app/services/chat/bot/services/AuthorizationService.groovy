package chat.bot.services

import chat.bot.AuthorizationMessage

class AuthorizationService {
    RequestHandler requestHandler = new RequestHandler()

    AuthorizationMessage getToken() {
        return requestHandler.makePostCall("https://google-trends-rest-api.herokuapp.com/login", '{"username": "chat_bot", "password": "chat_bot_password"}', AuthorizationMessage.class)
    }
}
