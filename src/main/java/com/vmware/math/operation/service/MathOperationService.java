package com.vmware.math.operation.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class MathOperationService {

	/**
	 * this is to add two values.
	 * 
	 * @param valueX
	 * @param valueY
	 * @return
	 */
	public String add(String valueX, String valueY) {

		BigInteger big1 = new BigInteger(valueX);
		BigInteger big2 = new BigInteger(valueY);

		return big1.add(big2).toString();
	}

	/**
	 * This is to subtract two values.
	 * 
	 * @param valueX
	 * @param valueY
	 * @return
	 */
	public String diff(String valueX, String valueY) {
		BigInteger big1 = new BigInteger(valueX);
		BigInteger big2 = new BigInteger(valueY);

		return big1.subtract(big2).toString();
	}

}
