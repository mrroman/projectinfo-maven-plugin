package com.offbytes.projectinfo.scm.git;

import com.offbytes.projectinfo.scm.SCMHandler;
import com.offbytes.projectinfo.scm.SCMHandlerFactory;

public class GitHandlerFactory extends SCMHandlerFactory{

	@Override
	protected SCMHandler newHandler(String basePath) {
		return new GitHandler(basePath);
	}	
	
}
