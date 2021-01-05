package chat.bot

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class TrendingSearch {
    Title title
    Image image
    Collection<Article> articles
    String shareUrl
}
