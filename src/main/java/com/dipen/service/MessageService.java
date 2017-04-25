package com.dipen.service;

import com.dipen.dao.DatabaseClass;
import com.dipen.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dipen on 4/25/2017.
 */
public class MessageService {

    private  Map<Long,Message> messages = DatabaseClass.getAllMessages();

    public  MessageService()
    {
        messages.put(1l,new Message(1,"Hello Dipen","Dilip"));
        messages.put(2l,new Message(2,"Hello Dipen","Dilip"));

    }
    public List<Message> getAllMessages()
    {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id)
    {
        return messages.get(id);
    }

    public Message addMessage(Message message)
    {
        message.setId(messages.size()+1);
        messages.put(message.getId(),message);
        return message;
    }

    public Message updateMessage(Message message)
    {
        if(message.getId() < 0)
        {
            return null;
        }
        messages.put(message.getId(),message);
        return message;
    }

    public Message removeMessage(long id)
    {
        System.out.print(id+"inside delete");
        return messages.remove(id);
    }
}
