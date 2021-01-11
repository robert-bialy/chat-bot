package chat.bot.services

import chat.bot.config.Constants

import java.util.logging.Level
import java.util.logging.Logger

class GoogleTrendsService {
    final RequestHandler requestHandler
    final Logger logger = Logger.getLogger("GoogleTrendsService")

    GoogleTrendsService(RequestHandler requestHandler) {
        this.requestHandler = requestHandler
    }


    Object getDailyTrends(String token) {
        String url = Constants.ApiUrl + '/dailyTrends?geo=US'
        try {
            return requestHandler.makeGetCall(url, Object.class, token)
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.message)
            return null
        }
    }
}
