package chat.bot.tasks

import chat.bot.facebookMessages.RequestMessage
import chat.bot.managers.MessageBuilderManager
import chat.bot.services.MessengerService

class HandleMessageTaskFactory {
    final MessageBuilderManager messageBuilderService
    final MessengerService messengerService

    HandleMessageTaskFactory(MessengerService messengerService, MessageBuilderManager messageBuilderService) {
        this.messageBuilderService = messageBuilderService
        this.messengerService = messengerService
    }

    HandleMessageTask createMessageTask(RequestMessage requestMessage) {
        return new HandleMessageTask(requestMessage,  messengerService, messageBuilderService)
    }
}
