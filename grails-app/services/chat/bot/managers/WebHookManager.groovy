package chat.bot.managers

class WebHookManager {
    String validateParameters(Map<String, String[]> parameters) {
        String mode = parameters.get("hub.mode").first()
        String challenge = parameters.get("hub.challenge").first()
        String token = parameters.get("hub.verify_token").first()

        if(mode.equals('subscribe') && token.equals('Robert')) {
            return challenge
        }

        return null
    }
}
