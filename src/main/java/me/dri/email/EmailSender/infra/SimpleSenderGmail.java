package me.dri.email.EmailSender.infra;

import me.dri.email.EmailSender.entities.adapters.GmailSenderGateway;
import me.dri.email.EmailSender.entities.exception.ContentIsEmptyException;
import me.dri.email.EmailSender.entities.exception.FastMailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleSenderGmail implements GmailSenderGateway {

    private final JavaMailSender emailSender;

    @Autowired
    public SimpleSenderGmail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public String sendEmailGmail(String receiver, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        if (receiver.isBlank() || receiver.isEmpty() || receiver.equals(" ")) {
            throw new ContentIsEmptyException("Receiver está vazio");
        }
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);
        try {
            this.emailSender.send(message);
            return "Email enviado com sucesso!";

        } catch (MailException e) {
            throw new FastMailException("Erro ao tentar enviar o email: "  + e.getMessage());
        }
    }
}
