package chat.bot.managers

import chat.bot.services.*
import chat.bot.tasks.HandleMessageTaskFactory

import java.util.concurrent.ForkJoinPool

class MessageDispatcherFactory {
    MessageDispatcher createMessageDispatcher() {
        RequestHandler requestHandler = new JavaConnectionRequestHandler()

        return new MessageDispatcher(
                new HandleMessageTaskFactory(
                        new HerokuGoogleTrendsManager(
                                new AuthorizationService(requestHandler),
                                new GoogleTrendsService(requestHandler)),
                        new FacebookMessengerService(requestHandler)),
                new ForkJoinPool())
    }
}
