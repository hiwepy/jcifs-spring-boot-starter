package net.jeebiz.smbclient.rename;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import net.jeebiz.smbclient.SMBClientConfig;

public class UUIDFileRenamePolicy implements FileRenamePolicy {
	
	protected SMBClientConfig config;
	
	@Override
	public void setClientConfig(SMBClientConfig config) {
		this.config = config;
	}

	@Override
	public String rename(String filename) {
		return StringUtils.join(new String[] { UUID.randomUUID().toString(), ".", FilenameUtils.getExtension(filename) });
	}
	
	@Override
	public File rename(File file) {
		String renamedName = this.rename(file.getName());
		// 是否开启本地备份功能
		if (config.isLocalBackupAble()) {
			try {
				// 尝试本地进行备份（如果已经开启）
				File renameFile = new File(config.getLocalBackupDir(), renamedName);
				FileUtils.copyFile(file, renameFile);
				return renameFile;
			} catch (IOException e) {
				// 忽略失败的情况
			}
		} else {
			try {
				File renameFile = new File(file.getParentFile(), renamedName);
				FileUtils.copyFile(file, renameFile);
				return renameFile;
			} catch (IOException e) {
				// 忽略失败的情况
			}
		}
		return file;
	}


}