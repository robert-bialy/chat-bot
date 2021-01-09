package chat.bot.tasks

import chat.bot.facebookMessages.RequestMessage
import chat.bot.googleTrends.DailyTrend
import chat.bot.managers.GoogleTrendsManager
import chat.bot.services.MessengerService

class HandleMessageTask implements Runnable {
    final RequestMessage requestMessage
    final MessengerService messengerService
    final GoogleTrendsManager googleTrendsManager

    HandleMessageTask(RequestMessage requestMessage, MessengerService messengerService, GoogleTrendsManager googleTrendsManager) {
        this.requestMessage = requestMessage
        this.messengerService = messengerService
        this.googleTrendsManager = googleTrendsManager
    }

    @Override
    void run() {
        Collection<DailyTrend> dailyTrends = googleTrendsManager.getDailyTrends()
        //messengerService.SendMessage(requestMessage.sender.id, "Test message")
    }
}
