package com.zuehlke.shmack.sparkjobs.infrastructure;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

public class ShmackUtils {

	public static void syncFolderToMasterAndSlave(File localSrcDir, File targetDirectory)
			throws ExecuteException, IOException {
		syncFolderToMasterAndSlave(localSrcDir, targetDirectory, 0);
	}
	
	public static void syncFolderToMasterAndSlave(File localSrcDir, File targetDirectory, int slaveIndex)
			throws ExecuteException, IOException {
		String line = "/bin/bash sync-to-dcos-master-and-slave.sh " + localSrcDir.getAbsolutePath() + "/ "
				+ targetDirectory.getAbsolutePath() + "/ " + slaveIndex;
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(cmdLine);
	}

	public static void syncFolderFromSlave(File remoteSrcDir, File localTargetDir)
			throws ExecuteException, IOException {
		syncFolderFromSlave(remoteSrcDir, localTargetDir, 0);
	}
	
	public static void syncFolderFromSlave(File remoteSrcDir, File localTargetDir, int slaveIndex) throws ExecuteException, IOException {
		String line = "/bin/bash sync-from-slave-to-local.sh " + remoteSrcDir.getAbsolutePath() + "/ "
				+ localTargetDir.getAbsolutePath() + "/ " + slaveIndex;
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(cmdLine);
	}


	public static void syncFolderToMaster(File localSrcDir, File targetDirectory)
			throws ExecuteException, IOException {
		String line = "/bin/bash sync-to-dcos-master.sh " + localSrcDir.getAbsolutePath() + "/ "
				+ targetDirectory.getAbsolutePath() + "/";
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(cmdLine);
	}

	public static void syncFolderFromMaster(File remoteSrcDir, File localTargetDir)
			throws ExecuteException, IOException {
		String line = "/bin/bash sync-from-master-to-local.sh " + remoteSrcDir.getAbsolutePath() + "/ "
				+ localTargetDir.getAbsolutePath() + "/";
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		executor.execute(cmdLine);
	}

//	public static void syncFolderToHdfs(File localSrcDir, File targetDirectory)
//			throws ExecuteException, IOException {
//		syncFolderToMasterAndSlave(localSrcDir, targetDirectory);
//	}

}
