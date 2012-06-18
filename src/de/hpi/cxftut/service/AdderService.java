package de.hpi.cxftut.service;

import javax.jws.*;		//contains the Annotations

@WebService
public interface AdderService {


    @WebMethod
    public abstract int add(@WebParam(name="a")int a, @WebParam(name="b")int b);
	
}
