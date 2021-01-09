package chat.bot.facebookMessages
import org.grails.web.json.JSONObject

class RequestMessage implements Serializable {
    RequestMessage(JSONObject jsonObject) {
        //change to non first index
        JSONObject entry = jsonObject.getJSONArray("entry").getJSONObject(0)
        JSONObject messaging = entry.getJSONArray("messaging").getJSONObject(0)
        this.sender = new User(messaging.getJSONObject("sender").getString("id"))
        this.recipient = new User(messaging.getJSONObject("recipient").getString("id"))
        this.message = new MessagePayload(messaging.getJSONObject("message"))
        this.timestamp = messaging.getLong("timestamp")
    }

    User sender
    MessagePayload message
    long timestamp
    User recipient
}
