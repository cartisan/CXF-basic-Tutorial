package de.hpi.cxftut.service;

import java.util.concurrent.Future;

import javax.jws.*;		//contains the Annotations
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import de.hpi.cxftut.service.jaxws.AddResponse;

@WebService
public interface AdderService {


    @WebMethod
    public abstract int add(@WebParam(name="a")int a, @WebParam(name="b")int b);
    
    // polling approach
    @WebMethod(operationName = "add")
    public abstract Response<AddResponse> addAsync(@WebParam(name="a")int a, @WebParam(name="b")int b);
    
    //callback approach
    @WebMethod(operationName = "add")
    public abstract Future<?> addAsync(@WebParam(name="a")int a, @WebParam(name="b")int b,
    										@WebParam(name="asyncHandler")AsyncHandler<AddResponse> asyncHandler);
	
}
