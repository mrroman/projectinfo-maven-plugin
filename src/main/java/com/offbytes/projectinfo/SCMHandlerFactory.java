package com.offbytes.projectinfo;

import java.util.ArrayList;
import java.util.List;

public abstract class SCMHandlerFactory {

	private static List<SCMHandlerFactory> handlerFactories = new ArrayList<SCMHandlerFactory>();
	
	public static void registerHandlerFactory(SCMHandlerFactory handler) {
		handlerFactories.add(handler);
	}
	
	public static SCMHandler findHandler(String basePath) {
		for (SCMHandlerFactory handlerFactory : handlerFactories) {
			SCMHandler handler = handlerFactory.newHandler(basePath);
			
			if (handler.detect()) {
				return handler; 
			}
		}
		
		throw new IllegalStateException("SCM not detected");
	}

	protected abstract SCMHandler newHandler(String basePath);
	
}
