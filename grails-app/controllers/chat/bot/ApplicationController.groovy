package chat.bot

import chat.bot.services.AuthorizationService
import grails.converters.JSON
import grails.rest.RestfulController

class ApplicationController extends RestfulController<Object> {
    AuthorizationService authorizationService

    ApplicationController() {
        super(Object)
    }

    def index() {
        render authorizationService.getToken() as JSON
    }
}
