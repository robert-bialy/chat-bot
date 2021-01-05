package chat.bot.services

class GoogleTrendsService {
    RequestHandler requestHandler
    Object getDailyTrends() {
        return requestHandler.makeGetCall("google-trends-rest-api.herokuapp.com/dailyTrends?geo=US", Object.class)
    }
}
