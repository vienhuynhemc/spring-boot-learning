package com.axonactive.simple_meta.service;

import com.axonactive.simple_meta.model.Message;

public interface MessageService {

    void sendMessage(String to, Message message);

}
