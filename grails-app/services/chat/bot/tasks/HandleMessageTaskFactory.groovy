package chat.bot.tasks

import chat.bot.facebookMessages.RequestMessage
import chat.bot.managers.GoogleTrendsManager
import chat.bot.services.MessengerService

class HandleMessageTaskFactory {
    final GoogleTrendsManager googleTrendsManager
    final MessengerService messengerService


    HandleMessageTaskFactory(GoogleTrendsManager googleTrendsManager, MessengerService messengerService) {
        this.googleTrendsManager = googleTrendsManager
        this.messengerService = messengerService
    }

    HandleMessageTask createMessageTask(RequestMessage requestMessage) {
        return new HandleMessageTask(requestMessage,  messengerService, googleTrendsManager)
    }
}
