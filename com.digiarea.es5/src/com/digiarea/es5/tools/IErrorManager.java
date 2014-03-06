package com.digiarea.es5.tools;

public interface IErrorManager {

	public enum ErrorType {
		INFO, WARNING, ERROR
	}

	public void report(ErrorType type, String message);

}
