package chat.bot.facebookMessages

class MessagePayload implements Serializable {
    MessagePayload(String text) {
        this.text = text
    }

    String text
}