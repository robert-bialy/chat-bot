package chat.bot.managers


import chat.bot.facebookMessages.RequestMessage
import chat.bot.services.MessengerService

class MessageDispatcher {
    final GoogleTrendsManager googleTrendsManager
    final MessengerService messengerService

    MessageDispatcher(GoogleTrendsManager googleTrendsManager, MessengerService messengerService) {
        this.googleTrendsManager = googleTrendsManager
        this.messengerService = messengerService
    }

    void HandleMessage(RequestMessage requestMessage) {
        //Collection<DailyTrend> dailyTrends = googleTrendsManager.getDailyTrends()
        messengerService.SendMessage(requestMessage.sender.id, "Test message")
    }
}
