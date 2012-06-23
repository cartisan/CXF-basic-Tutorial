package de.hpi.cxftut.service;

import java.util.concurrent.Future;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import de.hpi.cxftut.service.jaxws.AddResponse;

@WebService
public class AdderServiceImpl implements AdderService {

	@Override
	public int add(int a, int b) {
		System.out.printf("Oh my, I have to add %d and %d!", a, b);
		return a+b;
	}

	@Override
	public Response<AddResponse> addAsync(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<?> addAsync(int a, int b,
			AsyncHandler<AddResponse> asyncHandler) {
		// TODO Auto-generated method stub
		return null;
	}
}
