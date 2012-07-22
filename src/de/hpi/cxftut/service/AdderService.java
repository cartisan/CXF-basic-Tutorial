package de.hpi.cxftut.service;

import java.util.concurrent.Future;

import javax.jws.*;		//contains the Annotations
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import de.hpi.cxftut.service.jaxws.AddResponse;


@WebService
public interface AdderService {

    @WebMethod
	@RequestWrapper(localName = "add",
    		targetNamespace = "",
            className = "de.hpi.cxftut.service.jaxws.Add")
    @ResponseWrapper(localName = "addResponse",
    		targetNamespace = "",
            className = "de.hpi.cxftut.service.jaxws.AddResponse")
    public abstract int add(@WebParam(name="a")int a, @WebParam(name="b")int b);
    
    // polling approach
    @WebMethod(operationName = "add")
    public abstract Response<AddResponse> addAsync(@WebParam(name="a")int a, @WebParam(name="b")int b);
    
    // callback approach
    @WebMethod(operationName = "add")
    public abstract Future<?> addAsync(@WebParam(name="a")int a, @WebParam(name="b")int b,
    										@WebParam(name="asyncHandler")AsyncHandler<AddResponse> asyncHandler);
}
