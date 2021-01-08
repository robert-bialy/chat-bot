package chat.bot.services

interface MessengerService {
    def SendMessage(String senderId, String message)
}