package chat.bot.managers

import chat.bot.googleTrends.Article
import chat.bot.googleTrends.DailyTrend
import chat.bot.googleTrends.TrendingSearch

class GoogleTrendsMessageBuilderManager implements MessageBuilderManager {
    final GoogleTrendsManager googleTrendsManager

    GoogleTrendsMessageBuilderManager(GoogleTrendsManager googleTrendsManager) {
        this.googleTrendsManager = googleTrendsManager
    }

    @Override
    Collection<String> createMessage(String message) {
        Collection<String> response = getDailyTrendsResponse()
        return response
    }

    private Collection<String> getDailyTrendsResponse() {
        Collection<String> responses = new ArrayList<>()
        Collection<DailyTrend> dailyTrends = googleTrendsManager.getDailyTrends()
        DailyTrend todayDailyTrends = dailyTrends.first()
        String todayResponse = "Today trending news: "
        for(TrendingSearch trendingSearch in todayDailyTrends.trendingSearches) {
            Article article = trendingSearch.articles.first()
            todayResponse <<= String.format("%n %s", article.title)
            todayResponse <<= String.format("%n %s", article.url)
        }
        responses.add(todayResponse)

        if(dailyTrends.size() == 2) {
            //api response contains yesterday news
            String yesterdayResponse = "Yesterdays trending news: "
            DailyTrend yesterdayDailyTrends = dailyTrends[1]
            for(TrendingSearch trendingSearch in yesterdayDailyTrends.trendingSearches) {
                Article article = trendingSearch.articles.first()
                yesterdayResponse <<= String.format("%n %s", article.title)
                yesterdayResponse <<= String.format("%n %s", article.url)
            }
            responses.add(yesterdayResponse)
        }

        return responses
    }
}
