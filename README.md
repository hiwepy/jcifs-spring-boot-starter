# spring-boot-starter-jcifs
Spring Boot Starter For Jcifs

### 说明

 > 基于jcifs的smb协议扩展，实现连接的复用，减少smb连接的消耗
1、基于ThreadLocal机制实现的SMBClient扩展，实现当前线程的SMBClient 对象复用
2、基于jcifs 和 commons-pool2实现的SMBClient扩展；实现SMBClient对象池复用
3、扩展SmbFile文件过滤实现
4、扩展SMBClient工具函数

1. 整合 jcifs

### Maven

``` xml
<dependency>
	<groupId>${project.groupId}</groupId>
	<artifactId>spring-boot-starter-jcifs</artifactId>
	<version>${project.version}</version>
</dependency>
```

### Sample

```java


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.jeebiz.smbclient.client.ISMBClient;

@EnableSMBClient
@SpringBootApplication
public class Application {
	
	@Autowired
	public ISMBClient smbClient;
	
	@PostConstruct
	private void init() {
		
		//smbClient.upload(localFile, ftpFileName)
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}

```
