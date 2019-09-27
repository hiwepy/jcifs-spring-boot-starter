package net.jeebiz.smbclient.client;


import net.jeebiz.smbclient.SMBClient;
import net.jeebiz.smbclient.SMBClientConfig;
import net.jeebiz.smbclient.pool.SMBClientPool;
 
/**
 * 基于 Apache Pool2的SMBClient共享文件资源服务客户端实现
 * @author 		： <a href="https://github.com/vindell">vindell</a>
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
