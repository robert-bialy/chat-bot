package chat.bot

class UrlMappings {

    static mappings = {
        get "/"(controller: 'application', action: 'webhook')
        post "/"(controller: 'application', action: 'index')
    }
}
