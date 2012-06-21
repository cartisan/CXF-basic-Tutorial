package de.hpi.cxftut.service;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class AdderStandaloneServer {

	public AdderStandaloneServer(String serviceAddress) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		
		//register and publish WebService interface
		factory.setServiceClass(AdderService.class);
		factory.setAddress(serviceAddress);
		factory.setServiceBean(new AdderServiceImpl());
		
		//create WebService instance
		factory.create();	
	}
	
	public static void main(String[] args) {
		new AdderStandaloneServer("http://localhost:8080/adder");
		System.out.println("Server ready.");
	}

}
