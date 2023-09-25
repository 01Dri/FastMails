package me.dri.email.EmailSender.usecases;

import me.dri.email.EmailSender.entities.adapters.GmailSenderGateway;
import me.dri.email.EmailSender.entities.adapters.IGmailSender;
import me.dri.email.EmailSender.entities.exception.ContentIsEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderGmailServices implements IGmailSender {

    private final GmailSenderGateway emailSenderGateway;

    @Autowired
    public SenderGmailServices(GmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }


    public String sendEmailGmail(String receiver, String subject, String body) throws ContentIsEmptyException {
        return this.emailSenderGateway.sendEmailGmail(receiver, subject, body);
    }
}
