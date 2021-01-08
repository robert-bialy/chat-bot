package chat.bot.managers

import chat.bot.facebookMessages.RequestMessage
import chat.bot.tasks.HandleMessageTaskFactory

import java.util.concurrent.ExecutorService

class MessageDispatcher {
    final HandleMessageTaskFactory handleMessageTaskFactory
    final ExecutorService executorService

    MessageDispatcher(HandleMessageTaskFactory handleMessageTaskFactory, ExecutorService executorService) {
        this.handleMessageTaskFactory = handleMessageTaskFactory
        this.executorService = executorService
    }

    void HandleMessage(RequestMessage requestMessage) {
        def handleMessageTask = handleMessageTaskFactory.createMessageTask(requestMessage)
        executorService.execute(handleMessageTask)
    }
}
