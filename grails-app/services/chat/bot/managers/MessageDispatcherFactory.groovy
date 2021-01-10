package chat.bot.managers

import chat.bot.services.*
import chat.bot.tasks.HandleMessageTaskFactory

import java.util.concurrent.ForkJoinPool

class MessageDispatcherFactory {
    MessageDispatcher createMessageDispatcher() {
        RequestHandler requestHandler = new JavaConnectionRequestHandler()
        GoogleTrendsManager googleTrendsManager = new HerokuGoogleTrendsManager(
                new AuthorizationService(requestHandler),
                new GoogleTrendsService(requestHandler))

        return new MessageDispatcher(
                new HandleMessageTaskFactory(
                        new FacebookMessengerService(requestHandler),
                        new GoogleTrendsMessageBuilderManager(googleTrendsManager)),
                new ForkJoinPool())
    }
}
