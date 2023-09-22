package me.dri.email.EmailSender.core;

public interface IEmailSenderGmail {

    String sendEmail(String sender, String receiver, String body, String img);
}
