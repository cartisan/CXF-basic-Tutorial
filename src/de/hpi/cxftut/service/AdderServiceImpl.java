package de.hpi.cxftut.service;

import javax.jws.WebService;

@WebService
public class AdderServiceImpl implements AdderService {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
