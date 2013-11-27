package com.offbytes.projectinfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;

public class Commands {

	public static String execute(String basePath, String command, String... arguments) {
		CommandLine cmdLine = new CommandLine(command);
		cmdLine.addArguments(arguments);

		Executor executor = new DefaultExecutor();
		executor.setWorkingDirectory(new File(basePath));
		ByteArrayOutputStream outAndErr = new ByteArrayOutputStream();
		executor.setStreamHandler(new PumpStreamHandler(outAndErr));
		try {
			executor.execute(cmdLine);
			
			return outAndErr.toString();
		} catch (ExecuteException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
