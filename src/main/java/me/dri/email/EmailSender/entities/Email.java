package me.dri.email.EmailSender.entities;

public class Email {

    private String subject;
    private String receiver;

    private String body;

    public Email() {


    }

    public Email( String subject, String receiver, String body) {
        this.subject = subject;
        this.receiver = receiver;
        this.body = body;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
