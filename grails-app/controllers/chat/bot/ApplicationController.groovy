package chat.bot

import chat.bot.facebookMessages.RequestMessage
import chat.bot.managers.MessageDispatcher
import chat.bot.managers.WebHookManager
import grails.converters.JSON
import grails.rest.RestfulController
import org.grails.web.json.JSONObject

class ApplicationController extends RestfulController<Object> {
    WebHookManager webHookManager = new WebHookManager()
    MessageDispatcherFactory messageDispatcherFactory = new MessageDispatcherFactory()

    ApplicationController() {
        super(Object)
    }

    def index() {
        String body = request.getInputStream().getText()
        JSONObject messageObject = JSON.parse(body)
        RequestMessage message = new RequestMessage(messageObject)
        MessageDispatcher messageDispatcher = messageDispatcherFactory.createMessageDispatcher()
        messageDispatcher.HandleMessage(message)

        render (contentType: 'text/json', status: 200, text: "Message sent")
    }

    def webhook() {
        String challenge = webHookManager.validateParameters(request.parameterMap)

        if(challenge != null) {
            render (contentType: 'text/json', status: 200, results: challenge)
        } else {
            render (contentType: 'text/json', status: 403, text: 'Invalid verification token')
        }
    }
}
