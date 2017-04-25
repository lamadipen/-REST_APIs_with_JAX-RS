package com.dipen.resources;

import com.dipen.model.Message;
import com.dipen.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dipen on 4/24/2017.
 */
@Path("/messages")
public class MessageResource {

    MessageService ms = new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages()
    {
        return ms.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        return ms.getMessage(messageId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message)
    {
        return ms.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message,@PathParam("messageId") long messageId)
    {
        message.setId(messageId);
        return ms.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") long messageId)
    {
        ms.removeMessage(messageId);
    }

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test()
    {
        return "Method path test";
    }
}
