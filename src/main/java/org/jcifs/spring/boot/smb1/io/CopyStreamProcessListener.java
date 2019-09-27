package net.jeebiz.smbclient.io;

/**
 * 数据处理进度监听抽象实现，可继承该对象进行进度检测
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 */
public abstract class CopyStreamProcessListener {
	
	// 文件名称
	protected String fileName;
	
	public CopyStreamProcessListener(){
		
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	 /**
     * This method is not part of the JavaBeans model and is used by the
     * static methods in the org.apache.commons.io.Util class for efficiency.
     * It is invoked after a block of bytes to inform the listener of the
     * transfer.
     * @param totalBytesTransferred  The total number of bytes transferred
     *         so far by the copy operation.
     * @param bytesTransferred  The number of bytes copied by the most recent
     *          write.
     * @param streamSize The number of bytes in the stream being copied.
     *        This may be equal to CopyStreamEvent.UNKNOWN_STREAM_SIZE if
     *        the size is unknown.
     */
    public abstract void bytesTransferred(long totalBytesTransferred,
                                 int bytesTransferred,
                                 long streamSize);
	
}
