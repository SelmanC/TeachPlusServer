package com.teachplus.Entity;

import java.util.ArrayList;
import java.util.List;

public class MessageWrapper {
    private List<Message> messagesByFromId;
    private List<Message> messagesByToGroupId;
    private List<Message> messagesByToUserId;

    public MessageWrapper() {}

    public MessageWrapper(List<Message> messagesByFromId, List<Message> messagesByToGroupId, List<Message> messagesByToUserId) {
        this.messagesByFromId = messagesByFromId;
        this.messagesByToGroupId = messagesByToGroupId;
        this.messagesByToUserId = messagesByToUserId;
    }

    public List<Message> getMessagesByFromId() {
        return messagesByFromId;
    }

    public void setMessagesByFromId(List<Message> messagesByFromId) {
        this.messagesByFromId = messagesByFromId;
    }

    public List<Message> getMessagesByToGroupId() {
        return messagesByToGroupId;
    }

    public void setMessagesByToGroupId(List<Message> messagesByToGroupId) {
        this.messagesByToGroupId = messagesByToGroupId;
    }

    public List<Message> getMessagesByToUserId() {
        return messagesByToUserId;
    }

    public void setMessagesByToUserId(List<Message> messagesByToUserId) {
        this.messagesByToUserId = messagesByToUserId;
    }
}
