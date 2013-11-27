package com.offbytes.projectinfo.scm;

import java.util.ArrayList;
import java.util.List;

import com.offbytes.projectinfo.scm.hg.HgHandlerFactory;

public abstract class SCMHandlerFactory {

	private static List<SCMHandlerFactory> handlerFactories = new ArrayList<SCMHandlerFactory>();
	
	static {
		handlerFactories.add(new HgHandlerFactory());
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
