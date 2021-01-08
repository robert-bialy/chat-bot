package chat.bot.services

interface RequestHandler {
    def <T> T makePostCall(String url, String message, Class<T> requiredType, String token)
    def <T> T makeGetCall(String url, Class<T> requiredType, String token)
}