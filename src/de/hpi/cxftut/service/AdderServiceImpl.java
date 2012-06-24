package de.hpi.cxftut.service;

import javax.jws.WebService;


@WebService
public class AdderServiceImpl implements AdderService {

	@Override
	public int add(int a, int b) {
		System.out.printf("Oh my, I have to add %d and %d! \n", a, b);
		return a+b;
	}
}
