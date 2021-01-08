package chat.bot.managers

import chat.bot.googleTrends.DailyTrend

interface GoogleTrendsManager {
    Collection<DailyTrend> getDailyTrends()
}