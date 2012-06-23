package de.hpi.cxftut.client;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import de.hpi.cxftut.service.jaxws.AddResponse;

public class AddCallbackHandler implements
	AsyncHandler<AddResponse> {

	private AddResponse output;

	@Override
	public void handleResponse(Response<AddResponse> response) {
		try {
			output = response.get ();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public AddResponse getResponse (){
		return output;
	}	
}
