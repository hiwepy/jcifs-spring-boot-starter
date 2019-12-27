package org.jcifs.spring.boot.smb1.client;


import org.jcifs.spring.boot.smb1.SMBClient;
import org.jcifs.spring.boot.smb1.SMBClientConfig;
import org.jcifs.spring.boot.smb1.pool.SMBClientPool;
 
/**
 * 基于 Apache Pool2的SMBClient共享文件资源服务客户端实现
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
public class SMBPooledResourceClient extends SMBResourceClient{
	
	private SMBClientPool clientPool = null;
	private SMBClientConfig clientConfig = null;
	
	public SMBPooledResourceClient(SMBClientPool clientPool, SMBClientConfig clientConfig){
		 this.clientPool = clientPool;
		 this.clientConfig = clientConfig;
	} 
	
	public SMBPooledResourceClient(){
		 
	}
	 
	@Override
	public SMBClient getSMBClient() throws Exception {
		//从对象池获取SMBClient对象
		return clientPool.borrowObject();
	}
 
	@Override
	public void releaseClient(SMBClient smbClient) throws Exception{
		
		try {
			//释放SMBClient到对象池
			if(smbClient !=null){
				clientPool.returnObject(smbClient);
			}
		} catch (Throwable e) {
			 
		}
		
	}
	
	public SMBClientConfig getClientConfig() {
		return clientConfig;
	}
	
}
