package com.offbytes.projectinfo.scm.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import com.offbytes.projectinfo.scm.SCMHandler;

public class GitHandler implements SCMHandler {

	private final String basePath;
	private Repository repository;

	public GitHandler(String basePath) {
		this.basePath = basePath;
	}
	
	public boolean detect() {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		builder.setGitDir(new File(basePath))
		  .readEnvironment()
		  .findGitDir();
		  
		return builder.getGitDir() != null;
	}
	
	public String getBranch() {
		try {
			return repository().getBranch();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	public String getRevision() {
		try {
			return repository().resolve("HEAD").getName();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	public Repository repository() {
		if (this.repository == null) {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			try {
				this.repository = builder.setGitDir(new File(basePath))
				  .readEnvironment()
				  .findGitDir()
				  .build();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return this.repository;
	}
	
}
