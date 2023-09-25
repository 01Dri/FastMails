package me.dri.email.EmailSender.entities.exception;


public class ContentIsEmptyException extends  RuntimeException {
    public ContentIsEmptyException(String msg) {
        super(msg);
    }
}
