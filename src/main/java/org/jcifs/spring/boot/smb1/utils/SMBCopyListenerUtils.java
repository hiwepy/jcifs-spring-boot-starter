package net.jeebiz.smbclient.utils;

import net.jeebiz.smbclient.SMBClient;
import net.jeebiz.smbclient.io.CopyStreamProcessListener;

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
