package me.dri.email.EmailSender.exception;


public class ContentIsEmptyException extends  RuntimeException {
    public ContentIsEmptyException(String msg) {
        super(msg);
    }
}
