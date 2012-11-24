package util;

import java.io.Serializable;

public class Message implements Serializable {

    private String text;
    /*
     * Possible states:
     *  block
     *  error
     *  success
     *  info
     *
     * Reference: http://twitter.github.com/bootstrap/components.html#alerts
     */
    private String state;



    public Message(String text) {
        this(text, "info");
    }

    public Message(String text, String state) {
        this.text = text;
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
