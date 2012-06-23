package de.hpi.cxftut.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.Response;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.hpi.cxftut.service.AdderService;
import de.hpi.cxftut.service.jaxws.AddResponse;

public class TestClient {

	private AdderService adder;
	
	public TestClient(String serviceAddress) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(AdderService.class);
	    factory.setAddress(serviceAddress);
		this.adder = (AdderService) factory.create();	
	}
	
	private void doSomething(Future<?> asyncResponse) {
		Integer waitCount = 0;
		while(!asyncResponse.isDone()) {
			waitCount+=1;
		}
		System.out.println("\n Waited: "+ String.valueOf(waitCount)+ " cycles");
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TestClient client = new TestClient("http://localhost:8080/adder");
		int a = 15;
		int b = 17;
		
		System.out.printf("Synchron: %d + %d = %d \n", a,b, client.adder.add(a, b));
		
		Response<AddResponse> pollingResponse = client.adder.addAsync(a, b);
		client.doSomething(pollingResponse);
		int result = pollingResponse.get().get_return();
		System.out.printf("Polling: %d + %d = %d \n", a,b, result);
		
		AddCallbackHandler callbackHandler = new AddCallbackHandler ();
		Future<?> responseCallback = client.adder.addAsync(a, b, callbackHandler);
		client.doSomething(responseCallback);
		result = callbackHandler.getResponse().get_return();
		System.out.printf("Callback: %d + %d = %d", a,b, client.adder.add(a, b));
	}
}
