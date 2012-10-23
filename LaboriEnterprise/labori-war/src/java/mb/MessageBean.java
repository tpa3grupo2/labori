package mb;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Message;

@ManagedBean
@SessionScoped
public class MessageBean implements Serializable {

    private ArrayList<Message> messages = new ArrayList<Message>();

    public ArrayList getMessages() {
        ArrayList<Message> returnList = new ArrayList<Message>(messages);
        messages.clear();
        return returnList;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addMessage(String message, String state) {
        addMessage(new Message(message, state));
    }

    public Message readMessage() {
        Message message = (Message) messages.get(0);
        messages.remove(0);
        return message;
    }

    public int countMessages() {
        return messages.size();
    }
}
