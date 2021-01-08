package chat.bot.managers

class WebHookManager {
    String verificationToken = 'Robert'
    String verificationMode = 'subscribe'

    String validateParameters(Map<String, String[]> parameters) {
        String mode = parameters.get("hub.mode").first()
        String challenge = parameters.get("hub.challenge").first()
        String token = parameters.get("hub.verify_token").first()

        if(mode.equals(verificationMode) && token.equals(verificationToken)) {
            return challenge
        }

        return null
    }
}
