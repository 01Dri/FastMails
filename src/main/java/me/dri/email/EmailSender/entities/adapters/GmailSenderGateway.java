package me.dri.email.EmailSender.entities.adapters;

public interface GmailSenderGateway {

    String sendEmailGmail(String receiver, String subject, String body);
}
