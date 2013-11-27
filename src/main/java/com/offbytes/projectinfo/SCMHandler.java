package com.offbytes.projectinfo;

public interface SCMHandler {

	boolean detect();

	String getBranch();

	String getRevision();

}
