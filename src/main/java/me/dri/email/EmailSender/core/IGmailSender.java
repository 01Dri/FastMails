package me.dri.email.EmailSender.core;


public interface IGmailSender {

    String sendEmailGmail(String receiver, String subject, String body);

}
