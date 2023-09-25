package me.dri.email.EmailSender.entities.exception;


public class FastMailException extends  RuntimeException {
    public FastMailException(String msg) {
        super(msg);
    }
}
