package chat.bot.managers

import chat.bot.googleTrends.DailyTrend
import chat.bot.services.AuthorizationService
import chat.bot.services.GoogleTrendsService

class HerokuGoogleTrendsManager implements GoogleTrendsManager {
    final AuthorizationService authorizationService
    final GoogleTrendsService googleTrendsService

    HerokuGoogleTrendsManager(AuthorizationService authorizationService, GoogleTrendsService googleTrendsService) {
        this.authorizationService = authorizationService
        this.googleTrendsService = googleTrendsService
    }

    String authorizationKey

    Collection<DailyTrend> getDailyTrends() {
        if(authorizationKey == null) {
            authorizationKey = authorizationService.getToken().getAccessToken()
        }

        Collection<DailyTrend> dailyTrends = (Collection<DailyTrend>)googleTrendsService.getDailyTrends(authorizationKey)
        return dailyTrends
    }

}
