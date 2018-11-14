package com.teachplus.Service;

import com.teachplus.Entity.Group;
import com.teachplus.Entity.Message;
import com.teachplus.Entity.MessageWrapper;
import com.teachplus.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public MessageWrapper getMessagesForUser(Long userId, Long[] groupIds) {
        List<Message> messagesByFromId = messageRepository.getMessageByFromId(userId);
        List<Message> messagesByToUserId = messageRepository.getMessageByToUserId(userId);
        List<Message> messagesByToGroupId = messageRepository.getMessageByToGroupIds(groupIds);

        return new MessageWrapper(messagesByFromId, messagesByToGroupId, messagesByToUserId);
    }


    public List<Message> getAllMessagesForUser(Long userId, Long[] groupIds) {
        List<Message> messages = messageRepository.getAllMessages(groupIds, userId);

        return messages;
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
}
