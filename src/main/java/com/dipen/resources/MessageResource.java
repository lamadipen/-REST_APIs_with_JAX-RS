package com.dipen.resources;

import com.dipen.model.Message;
import com.dipen.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dipen on 4/24/2017.
 */
@Path("/messages")
public class MessageResource {

    MessageService ms = new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessage()
    {
        return ms.getAllMessages();
    }
}
