package chat.bot.tasks

import chat.bot.facebookMessages.RequestMessage
import chat.bot.managers.MessageBuilderManager
import chat.bot.services.MessengerService

class HandleMessageTask implements Runnable {
    final RequestMessage requestMessage
    final MessengerService messengerService
    final MessageBuilderManager messageBuilderService

    HandleMessageTask(RequestMessage requestMessage, MessengerService messengerService, MessageBuilderManager messageBuilderService) {
        this.requestMessage = requestMessage
        this.messengerService = messengerService
        this.messageBuilderService = messageBuilderService
    }

    @Override
    void run() {
        Collection<String> responseMessages = messageBuilderService.createMessage(requestMessage.message.text)

        for (String message in responseMessages) {
            messengerService.SendMessage(requestMessage.sender.id, message)
        }
    }
}
