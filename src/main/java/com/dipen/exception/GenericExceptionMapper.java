package com.dipen.exception;

import com.dipen.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by dipen on 4/26/2017.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{


    @Override
    public Response toResponse(Throwable throwable) {
        ErrorMessage errorMessage = new ErrorMessage(throwable.getMessage(),500,"www.google.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                entity(errorMessage).
                build();
    }
}
