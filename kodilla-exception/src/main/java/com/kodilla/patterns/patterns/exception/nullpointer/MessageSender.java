package com.kodilla.patterns.patterns.exception.nullpointer;

public class MessageSender {
    public void sendMessageTo(User user, String message) throws MessageNotSendException {

        if (user != null) {
            System.out.println("Sending message " + message + " to " + user.getName());
        }
        throw new MessageNotSendException("Object User was null");
    }
}
