package com.axonactive.simple_meta.controller;

import com.axonactive.simple_meta.model.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
public interface MessageController {

    @MessageMapping(value = "/{to}")
    void sendMessage(@DestinationVariable(value = "to") String to, Message message);

}
