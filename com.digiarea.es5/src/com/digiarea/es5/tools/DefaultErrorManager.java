package com.digiarea.es5.tools;

public class DefaultErrorManager implements IErrorManager {

	@Override
	public void report(ErrorType type, String message) {
		System.out.println(type.name() + " " + message);
	}

}
