package me.dri.email.EmailSender.entities.adapters;

public interface IGmailSender {

    String sendEmailGmail(String receiver, String subject, String body);
}
