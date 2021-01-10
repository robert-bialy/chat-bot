package chat.bot.managers

interface MessageBuilderManager {
    Collection<String> createMessage(String message)
}