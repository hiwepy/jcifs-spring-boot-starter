package org.jcifs.spring.boot.smb1.utils;

import org.jcifs.spring.boot.smb1.SMBClient;
import org.jcifs.spring.boot.smb1.io.CopyStreamProcessListener;

public class SMBCopyListenerUtils {

	public static void initCopyListener(SMBClient sharedFile,String filename){
		//进度监听
		CopyStreamProcessListener listener = sharedFile.getCopyStreamProcessListener();
		//判断监听存在
		if(listener != null){
	    	listener.setFileName(filename);
	    }
	}
	
}
