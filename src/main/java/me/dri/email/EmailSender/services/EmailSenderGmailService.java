package me.dri.email.EmailSender.services;

import me.dri.email.EmailSender.adapters.EmailSenderGmailGateway;
import me.dri.email.EmailSender.core.IEmailSenderGmail;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailSenderGmailService implements IEmailSenderGmail {


    private final EmailSenderGmailGateway emailSenderGmailGateway;
    @Autowired
    private EmailSenderGmailService(EmailSenderGmailGateway emailSenderGmailGateway) {
        this.emailSenderGmailGateway = emailSenderGmailGateway;

    }

    @Override
    public String sendEmail(String sender, String receiver, String body, String img) {
        this.emailSenderGmailGateway.sendEmail(sender, receiver, body, img);
        return null;
    }
}
