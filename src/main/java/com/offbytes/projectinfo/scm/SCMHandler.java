package com.offbytes.projectinfo.scm;

public interface SCMHandler {

	boolean detect();

	String getBranch();

	String getRevision();

}
