package me.dri.email.EmailSender.adapters;

public interface EmailSenderGmailGateway {

    void sendEmail(String sender, String receiver, String body, String img);
}
