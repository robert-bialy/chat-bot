package chat.bot.facebookMessages
import org.grails.web.json.JSONObject

class RequestMessage implements Serializable {
    RequestMessage(JSONObject jsonObject) {
        this.sender = new User(jsonObject.getJSONObject("sender").getString("id"))
        this.recipient = new User(jsonObject.getJSONObject("recipient").getString("id"))
        this.message = new MessagePayload(jsonObject.getJSONObject("message"))
        this.timestamp = jsonObject.getLong("timestamp")
    }

    User sender
    MessagePayload message
    long timestamp
    User recipient
}
