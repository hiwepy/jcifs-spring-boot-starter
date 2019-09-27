package net.jeebiz.smbclient.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;

import net.jeebiz.smbclient.SMBClient;

/**
 * SMBClient连接池
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 */
public class SMBClientPool extends GenericObjectPool<SMBClient> {


	/**
	 * 初始化连接池，需要注入一个工厂来提供SMBClient实例和连接池初始化对象
	 * @param factory
	 * @param config
	 */
	public SMBClientPool(SMBPooledClientFactory factory,SMBClientPoolConfig config){
		super(factory,config);
	}

}