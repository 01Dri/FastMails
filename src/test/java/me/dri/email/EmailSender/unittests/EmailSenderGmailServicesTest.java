package me.dri.email.EmailSender.unittests;

import me.dri.email.EmailSender.entities.adapters.GmailSenderGateway;
import me.dri.email.EmailSender.entities.Email;
import me.dri.email.EmailSender.entities.exception.ContentIsEmptyException;
import me.dri.email.EmailSender.usecases.SenderGmailServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class EmailSenderGmailServicesTest {

    SenderGmailServices emailSenderServices;

    @Mock
    private GmailSenderGateway emailSenderGateway;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        emailSenderServices = new SenderGmailServices(emailSenderGateway);
    }

    @Test
    void testSenderEmailGmail() {
        Email email = new Email("assunto teste", "diegohenriquemagalheas@gmail.com", "Teste de mensagem");
        when(emailSenderGateway.sendEmailGmail(email.getReceiver(), email.getSubject(), email.getBody())).thenReturn("Email enviado com sucesso!");
        String result = this.emailSenderServices.sendEmailGmail(email.getReceiver(), email.getSubject(), email.getBody());
        assertEquals("Email enviado com sucesso!", result);

    }
    @Test
    void testSenderGmailReceiverIsEmptyException() {
        String subject = "Teste";
        String receiver = "";
        String body = "Teste";

        when(emailSenderGateway.sendEmailGmail(subject, receiver, body)).thenThrow(new ContentIsEmptyException("Receiver está vazio"));
        try {
            String result = this.emailSenderServices.sendEmailGmail(subject, receiver, body);
            fail("Deveria lançar a exception ContentIsEmptyException");
        } catch (ContentIsEmptyException e) {
            assertEquals("Receiver está vazio", e.getMessage());


        }

    }



}
