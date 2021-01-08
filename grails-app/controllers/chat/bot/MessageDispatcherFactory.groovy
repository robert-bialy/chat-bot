package chat.bot

import chat.bot.managers.HerokuGoogleTrendsManager
import chat.bot.managers.MessageDispatcher
import chat.bot.services.AuthorizationService
import chat.bot.services.FacebookMessengerService
import chat.bot.services.GoogleTrendsService
import chat.bot.services.JavaConnectionRequestHandler
import chat.bot.services.RequestHandler

class MessageDispatcherFactory {
    MessageDispatcher createMessageDispatcher() {
        RequestHandler requestHandler = new JavaConnectionRequestHandler()

        return new MessageDispatcher(
                new HerokuGoogleTrendsManager(
                new AuthorizationService(requestHandler),
                new GoogleTrendsService(requestHandler)),
                new FacebookMessengerService(requestHandler))
    }
}
