/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.jcifs.spring.boot;

import org.jcifs.spring.boot.smb1.SMBClientConfig;
import org.jcifs.spring.boot.smb1.pool.SMBClientPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * SMBClient 参数配置
 * @author ： <a href="https://github.com/hiwepy">hiwepy</a>
 */
@ConfigurationProperties(SMBClientProperties.PREFIX)
public class SMBClientProperties extends SMBClientConfig {

	public static final String PREFIX = "smbclient";
	
	@NestedConfigurationProperty
	private SMBClientPoolConfig pool = new SMBClientPoolConfig();

	public SMBClientPoolConfig getPool() {
		return pool;
	}

	public void setPool(SMBClientPoolConfig pool) {
		this.pool = pool;
	}
	
}
