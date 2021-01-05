package chat.bot

import chat.bot.managers.GoogleTrendsManager
import grails.converters.JSON
import grails.rest.RestfulController

class ApplicationController extends RestfulController<Object> {
    GoogleTrendsManager googleTrendsManager = new GoogleTrendsManager()

    ApplicationController() {
        super(Object)
    }

    def index() {
        render googleTrendsManager.getDailyTrends() as JSON
    }
}
