package chat.bot

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class DailyTrend {
    String date
    Collection<TrendingSearch> trendingSearches
}

