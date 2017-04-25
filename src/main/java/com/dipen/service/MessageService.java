package com.dipen.service;

import com.dipen.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dipen on 4/25/2017.
 */
public class MessageService {

    public List<Message> getAllMessages()
    {
        List<Message> list = new ArrayList<>();
        list.add(new Message(1,"Hello Dipen","Dilip"));
        list.add(new Message(1,"Hello Suman","Dipen"));
        return list;
    }
}
