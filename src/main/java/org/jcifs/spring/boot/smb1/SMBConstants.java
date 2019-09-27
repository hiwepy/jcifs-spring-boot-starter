package net.jeebiz.smbclient;

public final class SMBConstants {

	//获取文件存储路径
	public static String DEFAULT_SMBCLIEN_WEB_LOCALDIR = "tmpdir";
	//获取请求过滤前缀
	public static String DEFAULT_SMBCLIEN_WEB_REQUESTPREFIX = "/smb/";
	//获取是否缓存SMB文件到本地存储路径
	public static boolean DEFAULT_SMBCLIEN_WEB_CACHELOCAL = false;
	//获取共享文件在本地缓存的时间;默认10分钟
	public static long DEFAULT_SMBCLIEN_WEB_CACHEEXPIRY = 10 * 60 * 1000;
	
	//获取文件存储路径
	public static String SMBCLIEN_WEB_LOCALDIR_KEY = "smbclient.web.tmpdir";
	//获取请求过滤前缀
	public static String SMBCLIEN_WEB_REQUESTPREFIX_KEY = "smbclient.web.requestPrefix";
	//获取是否缓存SMB文件到本地存储路径
	public static String SMBCLIEN_WEB_CACHELOCAL_KEY = "smbclient.web.cacheLocal";
	//获取共享文件在本地缓存的时间;默认10分钟
	public static String SMBCLIEN_WEB_CACHEEXPIRY_KEY = "smbclient.web.cacheExpiry";
	//异常信息重定向路径
	public static String SMBCLIEN_WEB_REDIRECTURL_KEY = "smbclient.web.redirectURL";
	
	
}
