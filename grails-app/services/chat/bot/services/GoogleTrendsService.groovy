package chat.bot.services

import chat.bot.config.Constants

class GoogleTrendsService {
    final RequestHandler requestHandler
    GoogleTrendsService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }


    Object getDailyTrends(String token) {
        return requestHandler.makeGetCall(Constants.ApiUrl + '/dailyTrends?geo=US', Object.class, token)
    }
}
