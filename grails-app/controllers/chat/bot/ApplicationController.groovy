package chat.bot

import chat.bot.managers.GoogleTrendsManager
import chat.bot.managers.WebHookManager
import grails.converters.JSON
import grails.rest.RestfulController

class ApplicationController extends RestfulController<Object> {
    GoogleTrendsManager googleTrendsManager = new GoogleTrendsManager()
    WebHookManager webHookManager = new WebHookManager()

    ApplicationController() {
        super(Object)
    }

    def index() {
        render (status: 200, text:  googleTrendsManager.getDailyTrends() as JSON)
    }

    def webhook() {
        String challenge = webHookManager.validateParameters(request.parameterMap)

        if(challenge != null) {
            render (status: 200, text: challenge)
        } else {
            render (status: 403, text: 'Invalid verification token')
        }
    }
}
