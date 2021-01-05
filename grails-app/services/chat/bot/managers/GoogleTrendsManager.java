package chat.bot.managers;

import chat.bot.services.AuthorizationService;
import chat.bot.services.GoogleTrendsService;

public class GoogleTrendsManager {
    AuthorizationService authorizationService = new AuthorizationService();
    GoogleTrendsService googleTrendsService = new GoogleTrendsService();
    String authorizationKey;

    public Object getDailyTrends() {
        if(authorizationKey == null) {
            authorizationKey = authorizationService.getToken().getAccessToken();
        }

        return googleTrendsService.getDailyTrends(authorizationKey);
    }

}
