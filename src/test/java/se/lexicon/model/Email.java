package se.lexicon.model;

public class Email extends Notofication {
    // Private fields
    private String recipient;
    private String subject;
    private String content;

    // Constructor for all private fields

    public Email(String recipient, String subject, String content) {
        super(); //Call the constructor from notification
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }

    // Getter and setter for all fields

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        //Condition for recipient should not be null
        if (recipient == null) throw new IllegalArgumentException("Recipient email is null");
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String summary() {
        return super.toString() + "-> Email sent to" + recipient
                + "with subject:" + subject;
    }
}
