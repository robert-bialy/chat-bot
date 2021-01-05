package chat.bot.services

import chat.bot.config.Constants

class GoogleTrendsService {
    RequestHandler requestHandler = new RequestHandler()

    Object getDailyTrends(String token) {
        return requestHandler.makeGetCall(Constants.ApiUrl + '/dailyTrends?geo=US', Object.class, token)
    }
}
