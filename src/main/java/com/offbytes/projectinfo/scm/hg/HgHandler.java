package com.offbytes.projectinfo.scm.hg;

import java.io.File;

import com.offbytes.projectinfo.Commands;
import com.offbytes.projectinfo.SCMHandler;

public class HgHandler implements SCMHandler {

	private final String basePath;

	public HgHandler(String basePath) {
		this.basePath = basePath;
	}

	public boolean detect() {
		File hgFolder = new File(basePath, ".hg");
		
		return hgFolder.exists() && hgFolder.isDirectory();
	}
	
	public String getBranch() {
		return id("-b").trim();
	}

	public String getRevision() {
		return id("-i").trim().replaceAll("\\+$", "");
	}

	private String id(String option) {
		return Commands.execute(basePath, "hg", "id", option);
	}

}
