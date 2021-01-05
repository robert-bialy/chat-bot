package chat.bot.managers

import chat.bot.DailyTrend
import chat.bot.services.AuthorizationService
import chat.bot.services.GoogleTrendsService

class GoogleTrendsManager {
    AuthorizationService authorizationService = new AuthorizationService()
    GoogleTrendsService googleTrendsService = new GoogleTrendsService()
    String authorizationKey

    Collection<DailyTrend> getDailyTrends() {
        if(authorizationKey == null) {
            authorizationKey = authorizationService.getToken().getAccessToken()
        }

        Collection<DailyTrend> dailyTrends = (Collection<DailyTrend>)googleTrendsService.getDailyTrends(authorizationKey)
        return dailyTrends
    }

}
