package org.jcifs.spring.boot.smb1.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 基于apache-pool2的对象池初始化对象
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
public class SMBClientPoolConfig extends GenericObjectPoolConfig {
	
	protected static Logger LOG = LoggerFactory.getLogger(SMBClientPoolConfig.class);
	
	/**
	 * If the SMBClient Pool should be enabled or not
	 */
	private boolean enabled = false;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
