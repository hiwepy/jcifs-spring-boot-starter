package org.jcifs.spring.boot;

import org.jcifs.spring.boot.smb1.SMBClientBuilder;
import org.jcifs.spring.boot.smb1.client.ISMBClient;
import org.jcifs.spring.boot.smb1.client.SMBPooledResourceClient;
import org.jcifs.spring.boot.smb1.client.SMBResourceClient;
import org.jcifs.spring.boot.smb1.pool.SMBClientPool;
import org.jcifs.spring.boot.smb1.pool.SMBPooledClientFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jcifs.smb.SmbFile;

@Configuration
@ConditionalOnClass({ ISMBClient.class, SmbFile.class })
@EnableConfigurationProperties({SMBClientProperties.class })
public class SMBClientConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	public SMBClientBuilder smbClientBuilder(SMBClientProperties properties) {
		return new SMBClientBuilder(properties);
	}
	
	@Bean
	public ISMBClient smbClient(SMBClientBuilder clientBuilder, SMBClientProperties properties) {
		
		if (properties.getPool().isEnabled()) {

			SMBPooledClientFactory factory = new SMBPooledClientFactory(clientBuilder);

			SMBClientPool clientPool = new SMBClientPool(factory, properties.getPool());

			return new SMBPooledResourceClient(clientPool, properties);
		}
		
		return new SMBResourceClient(clientBuilder);
	}

}
