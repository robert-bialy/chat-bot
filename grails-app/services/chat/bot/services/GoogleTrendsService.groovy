package chat.bot.services

class GoogleTrendsService {
    RequestHandler requestHandler = new RequestHandler()

    Object getDailyTrends(String token) {
        return requestHandler.makeGetCall(Config.ApiUrl + '/dailyTrends?geo=US', Object.class, token)
    }
}
