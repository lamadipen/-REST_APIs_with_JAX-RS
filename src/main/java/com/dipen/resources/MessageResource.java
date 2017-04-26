package com.dipen.resources;

import com.dipen.model.Message;
import com.dipen.service.MessageService;
import org.glassfish.jersey.server.Uri;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by dipen on 4/24/2017.
 */
@Path("/messages")
public class MessageResource {

    MessageService ms = new MessageService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size)
    {
        if(year > 0)
        {
            return ms.getAllMessagesForYear(year);
        }
        else if(start >= 0 && size >0)
        {
            return ms.getAllMessagesPaginated(start,size);
        }
        else
        {
            return ms.getAllMessages();
        }

    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo)
    {
        Message message =  ms.getMessage(messageId);
        String url = getUriForSelf(uriInfo, message);
        message.addLink(url,"self");
        message.addLink(getUriForProfile(uriInfo, message),"profile");
        message.addLink(getUriForComments(uriInfo, message),"comments");
        return message;
    }

    private String getUriForComments(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().
                path(MessageResource.class).
                path(MessageResource.class,"getCommentsByMessage" ).
                path(CommentResource.class).
                resolveTemplate("messageId",Long.toString(message.getId())).
                build().
                toString();
    }

    private String getUriForProfile(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().
                path(ProfileResource.class).
                path(message.getAuthor() ).
                build().
                toString();
    }

    public String getUriForSelf(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder().
                    path(MessageResource.class).
                    path(Long.toString(message.getId())).
                    build().
                    toString();
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

 /*   @GET
    @Path("/{messageId}/comments")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCommentsByMessage()
    {
        return "Getting Sub resoruces";
    }*/

    @Path("/{messageId}/comments")
    @Produces(MediaType.TEXT_PLAIN)
    public CommentResource getCommentsByMessage()
    {
        return new CommentResource();
    }

    /** Sample to modify headers and body by using Response Object**/
    @GET
    @Path("/customHeader/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageWithStatus(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) throws URISyntaxException {
       /* setting status code and location of newly created resource
        return Response.status(Response.Status.CREATED).
                entity(ms.getMessage(messageId)).
                header("location","messages/customHeader/1").
                build();*/

        //alternative and shortchut of above method, which is recommended way of implementing
    /*    Message message = ms.getMessage(messageId);
        return Response.created(new URI("/messages/"+message.getId())).
                entity(message).
                build();*/
        //generating URI dynamically using UriInfo
        Message message = ms.getMessage(messageId);
        String strMsgId = String.valueOf(message.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(strMsgId).build();
        return Response.created(uri).
                entity(message).
                build();
    }
}
