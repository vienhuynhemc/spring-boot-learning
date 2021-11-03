package com.axonactive.simple_meta.service.implement;

import com.axonactive.simple_meta.model.Message;
import com.axonactive.simple_meta.service.MessageService;
import com.axonactive.simple_meta.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImplement implements MessageService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void sendMessage(String to, Message message) {
        System.out.println("Xử lý gửi tin nhắn tới: " + to);
        if (UserStorage.getInstance().isExistUser(to)) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
