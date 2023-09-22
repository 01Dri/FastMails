package me.dri.email.EmailSender.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class EmailSenderServicesTest {

    IEmailSenderGmail emailSenderGmail;

    @BeforeEach
    void setup() {
        emailSenderGmail = new EmailSenderGmailServices();
    }

    @Test
    void testSenderEmailGmail() {
        String sender = "heenrikk3@gmail.com";
        String receiver = "diegohenriquemagalheas@gmail.com";
        String body = "Testando envio de mensagem";
        String img = "teste.jpg";

        var result = this.emailSenderGmail.sendEmail(sender, receiver, body, img);
        assertEquals("Email enviado com sucesso!", result);

    }
}
