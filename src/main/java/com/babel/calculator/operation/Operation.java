package com.babel.calculator.operation;

public enum Operation {
	ADD, SUB;

	private static final Operation[] values = new Operation[] { ADD, SUB };

	public static Operation validateOperation(String value) {

		for (Operation operation : values) {
			if (value.equalsIgnoreCase(operation.name())) {
				return operation;
			}
		}

		throw new RuntimeException("Unsupported operation: " + value);
	}

}