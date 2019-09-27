package net.jeebiz.smbclient.rename;

import java.io.File;

import net.jeebiz.smbclient.SMBClientConfig;

public interface FileRenamePolicy {

	public abstract void setClientConfig(SMBClientConfig config);
	
	public abstract String rename(String filename);
	
	public abstract File rename(File file);
	
}



