package me.dri.email.EmailSender.controllers;

import me.dri.email.EmailSender.entities.Email;
import me.dri.email.EmailSender.exception.FastMailException;
import me.dri.email.EmailSender.services.SenderGmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastmail")

public class SenderGmailController {

    private final SenderGmailServices emailSenderServices;

    @Autowired
    public SenderGmailController(SenderGmailServices emailSenderServices) {
        this.emailSenderServices = emailSenderServices;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendGmailEmail(@RequestBody Email email) {
        try {
            return ResponseEntity.ok().body(this.emailSenderServices.sendEmailGmail(email.getReceiver(), email.getSubject(), email.getBody()));
        } catch (FastMailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao enviar o email: " + e.getMessage());
        }
    }
}
