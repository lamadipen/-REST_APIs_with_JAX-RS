package com.dipen.exception;

import com.dipen.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by dipen on 4/26/2017.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(),404,"www.google.com");
        return Response.status(Response.Status.NOT_FOUND).
                entity(errorMessage).
                build();
    }
}
