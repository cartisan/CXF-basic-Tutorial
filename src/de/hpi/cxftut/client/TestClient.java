package de.hpi.cxftut.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import de.hpi.cxftut.service.AdderService;

public class TestClient {

	private AdderService adder;
	
	public TestClient(String serviceAddress) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(AdderService.class);
	    factory.setAddress(serviceAddress);
		this.adder = (AdderService) factory.create();	
	}
	
	
	public static void main(String[] args) {
		TestClient client = new TestClient("http://localhost:8080/adder");
		int a = 15;
		int b = 17;
		System.out.printf("%d + %d = %d", a,b, client.adder.add(a, b));
	}
}
