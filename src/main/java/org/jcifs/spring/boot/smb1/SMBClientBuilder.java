package org.jcifs.spring.boot.smb1;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcifs.SmbSession;
import jcifs.SmbTransportPool;
import jcifs.netbios.UniAddress;
import jcifs.smb.SmbTransportPoolImpl;
import jcifs.smb1.smb1.NtlmPasswordAuthentication;

import org.jcifs.spring.boot.smb1.io.CopyStreamProcessListener;
import org.jcifs.spring.boot.smb1.utils.SMBPathUtils;

/**
 *  SmbFile对象构建器
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
public class SMBClientBuilder implements Builder<SMBClient> {
	
	protected static Logger LOG = LoggerFactory.getLogger(SMBClientBuilder.class);
	private SMBClientConfig clientConfig;
	
	public SMBClientBuilder(SMBClientConfig config) {
		this.clientConfig = config;
	}

	@SuppressWarnings("unchecked")
	public SMBClient build() {
		
		//基于smb协议的共享文件访问对象
		SMBClient smbClient = null;
		
		try {
			
			if(StringUtils.isNotEmpty(clientConfig.getDomain())){
				//DOMAIN_IP         域名服务（其实域名和域名服务器IP可以，不过用IP解析速度快很多。）  
				//DOMAIN_NAME       域名  
				//LOGIN_NAME        用户名  
				//PASSWORD      密码  
				UniAddress address = new UniAddress(clientConfig.getHost());  
				NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication(clientConfig.getDomain(), clientConfig.getUsername(), clientConfig.getPassword());  
				
				SmbTransportPool SmbTransportPool = new SmbTransportPoolImpl();
				SmbTransportPool.logon(dc, address);  
				
				//创建基于smb协议的共享文件访问对象
				smbClient = new SMBClient( SMBPathUtils.getSharedURL(clientConfig.getHost(), clientConfig.getSharedDir()) , authentication);
			}else{
				//共享目录访问路径
				String sharedURL = SMBPathUtils.getSharedURL(clientConfig.getUsername(), clientConfig.getPassword(), clientConfig.getHost(), clientConfig.getSharedDir());
				//创建基于smb协议的共享文件访问对象
				smbClient = new SMBClient(sharedURL);
			}
			//启用或禁用用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查
			smbClient.setAllowUserInteraction(clientConfig.isAllowUserInteraction());
			//设置一个指定的超时值（以毫秒为单位），该值将在打开到此 URLConnection 引用的资源的通信链接时使用
			smbClient.setConnectTimeout(clientConfig.getConnectTimeout());
			//数据读取超时时间，以毫秒为单位
			smbClient.setReadTimeout(clientConfig.getReadTimeout());
			//启用或禁用在条件允许情况下允许协议使用缓存
			smbClient.setDefaultUseCaches(clientConfig.isUsecaches());
			smbClient.setUseCaches(clientConfig.isUsecaches());
			
			smbClient.setAutoFlush(clientConfig.isAutoFlush());
			smbClient.setAutoFlushBlockSize(clientConfig.getAutoFlushBlockSize());
			smbClient.setBufferSize(clientConfig.getBufferSize());
			smbClient.setChannelReadBufferSize(clientConfig.getChannelReadBufferSize());
			smbClient.setChannelWriteBufferSize(clientConfig.getChannelWriteBufferSize());
			smbClient.setLogDebug(clientConfig.isLogDebug());
			
			//进行存储时/检索操作时数据处理进度监听对象
			if(StringUtils.isNotEmpty(clientConfig.getCopyStreamProcessListenerName())){
				Class<CopyStreamProcessListener> listenerClazz = (Class<CopyStreamProcessListener>) Class.forName(clientConfig.getCopyStreamProcessListenerName());
				smbClient.setCopyStreamProcessListener((CopyStreamProcessListener) ConstructorUtils.invokeConstructor(listenerClazz));
			}else{
				smbClient.setCopyStreamProcessListener(clientConfig.getCopyStreamProcessListener());
			}
		} catch (Exception e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
		}
		
		return smbClient;
	}

	public void shutdown() throws IOException {

	}

	public SMBClientConfig getConfiguration() {
		return clientConfig;
	}
	
}
