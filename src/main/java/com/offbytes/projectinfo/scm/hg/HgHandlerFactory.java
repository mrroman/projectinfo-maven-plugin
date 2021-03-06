package com.offbytes.projectinfo.scm.hg;

import com.offbytes.projectinfo.scm.SCMHandler;
import com.offbytes.projectinfo.scm.SCMHandlerFactory;

public class HgHandlerFactory extends SCMHandlerFactory {

	@Override
	protected SCMHandler newHandler(String basePath) {
		return new HgHandler(basePath);
	}

}
