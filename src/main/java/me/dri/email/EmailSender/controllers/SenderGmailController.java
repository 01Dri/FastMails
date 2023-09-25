package me.dri.email.EmailSender.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.dri.email.EmailSender.entities.Email;
import me.dri.email.EmailSender.entities.exception.FastMailException;
import me.dri.email.EmailSender.usecases.SenderGmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastmail/v1")

public class SenderGmailController {

    private final SenderGmailServices emailSenderServices;

    @Autowired
    public SenderGmailController(SenderGmailServices emailSenderServices) {
        this.emailSenderServices = emailSenderServices;
    }

    @Operation(summary = "Enviar um email", description = "Basta enviar um body na request, contendo 'receiver', 'subject' e 'body' \n !IMPORTANTE: (Receiver não pode estar vazio)",
    tags = {"Email"}, responses = {@ApiResponse(description = "Sucess", responseCode = "200"
    , content = @Content(schema = @Schema(implementation = Email.class))),
    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content)})
    @PostMapping("/send")
    public ResponseEntity<String> sendGmailEmail(@RequestBody Email email) {
        try {
            return ResponseEntity.ok().body(this.emailSenderServices.sendEmailGmail(email.getReceiver(), email.getSubject(), email.getBody()));
        } catch (FastMailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao enviar o email: " + e.getMessage());
        }
    }
}
