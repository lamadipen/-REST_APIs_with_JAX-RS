package com.dipen.resources;

import com.dipen.backingBean.MessageBackingBean;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by dipen on 4/25/2017.
 */
@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    /**
     * Matrix parama is similar to regular param difference is as below
     *
     * http://localhost:8080/webapi/messages;value=10 matrix param uses ; instead of ?
     *
     * Header param in sent via header and used for security and authentication token/ session
     *
     * @FormParam
     * **/
    @GET
    @Path("matrix")
    public String getParamUsingAnnotation(@MatrixParam("value") String value,
                                 @HeaderParam("headerParam")String headerParam,
                                 @CookieParam("cookieParam")String cookieParam )
    {
        return "Matrix param : "+value + " Header Param : "+headerParam + "Cookie Param : "+cookieParam;
    }

    @GET
    @Path("context")
    public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers)
    {
        return "UriInfor using context param :"+uriInfo.getAbsolutePath().toString() + "Header using context param "+ headers.getCookies() ;
    }


    @GET
    @Path("beanParam")
    public String getMessages(@BeanParam MessageBackingBean messageBackingBean)
    {
        return "Getting message bean "+ messageBackingBean.getStart() + messageBackingBean.getYear();
    }

}
