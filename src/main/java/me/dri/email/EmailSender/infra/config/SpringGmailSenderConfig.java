package me.dri.email.EmailSender.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class SpringGmailSenderConfig {

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.username}")
    private String email;

    public void getProperties(JavaMailSenderImpl emailSender) {
        Properties props = emailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        System.out.println(password);
        mailSender.setUsername(this.email);
        mailSender.setPassword(this.password);
        this.getProperties(mailSender);
        return mailSender;

    }


}
