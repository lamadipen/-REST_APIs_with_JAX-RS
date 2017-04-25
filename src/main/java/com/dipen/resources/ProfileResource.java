package com.dipen.resources;
import com.dipen.model.Profile;
import com.dipen.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dipen on 4/24/2017.
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService ps = new ProfileService();
    @GET
    public List<Profile> getMessages()
    {
        return ps.getAllMessages();
    }

    @GET
    @Path("/{profileName}")
    public Profile getMessage(@PathParam("profileName") String profileName)
    {
        return ps.getMessage(profileName);
    }

    @POST
    public Profile addMessage(Profile message)
    {
        return ps.addMessage(message);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateMessage(Profile message,@PathParam("profileName") String profileName)
    {
        message.setProfileName(profileName);
        return ps.updateMessage(message);
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteMessage(@PathParam("profileName") String profileName)
    {
        ps.removeMessage(profileName);
    }

    @GET
    @Path("test")
    public String test()
    {
        return "Method path test";
    }
}
