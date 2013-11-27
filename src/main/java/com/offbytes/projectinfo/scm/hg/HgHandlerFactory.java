package com.offbytes.projectinfo.scm.hg;

import com.offbytes.projectinfo.SCMHandler;
import com.offbytes.projectinfo.SCMHandlerFactory;

public class HgHandlerFactory extends SCMHandlerFactory {

	static {
		SCMHandlerFactory.registerHandlerFactory(new HgHandlerFactory());
	}
	
	@Override
	protected SCMHandler newHandler(String basePath) {
		return new HgHandler(basePath);
	}

}
