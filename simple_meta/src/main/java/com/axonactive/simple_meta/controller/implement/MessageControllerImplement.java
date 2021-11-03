package com.axonactive.simple_meta.controller.implement;

import com.axonactive.simple_meta.controller.MessageController;
import com.axonactive.simple_meta.model.Message;
import com.axonactive.simple_meta.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageControllerImplement implements MessageController {

    private final MessageService messageService;

    @Override
    public void sendMessage(String to, Message message) {
        messageService.sendMessage(to,message);
    }

}
