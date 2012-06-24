package de.hpi.cxftut.service;

import javax.jws.*;		//contains the Annotations
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


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

}
