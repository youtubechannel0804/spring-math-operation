package com.vmware.math.operation.model;

import javax.validation.constraints.NotEmpty;

import com.vmware.math.operation.customvalidator.NumericString;

public class MathVariable {

	@NotEmpty
	@NumericString(message = "X should be numeric")
	private String x;

	@NotEmpty
	@NumericString(message = "Y should be numeric")
	private String y;

	public MathVariable() {
	}

	public MathVariable(String string, String string2) {
		this.x = string;
		this.y = string2;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

}
