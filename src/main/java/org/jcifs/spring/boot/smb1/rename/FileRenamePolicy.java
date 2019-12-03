package org.jcifs.spring.boot.smb1.rename;

import java.io.File;

import org.jcifs.spring.boot.smb1.SMBClientConfig;

public interface FileRenamePolicy {

	public abstract void setClientConfig(SMBClientConfig config);
	
	public abstract String rename(String filename);
	
	public abstract File rename(File file);
	
}



