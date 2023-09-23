package me.dri.email.EmailSender.adapters;

public interface GmailSenderGateway {

    String sendEmailGmail(String receiver, String subject, String body);
}
