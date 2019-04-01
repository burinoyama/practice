package org.vin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

abstract class Constants {

	//HBase配置信息
	static final Configuration CONF = HBaseConfiguration.create();

	//命名空间
	static final String NS = "weibo";

	//微博内容表
	static final String CONTENT_TABLE = "weibo:content";
	static final String CONTENT_CF = "info";

	//用户关系表
	static final String RELATION_TABLE = "weibo:relation";
	static final String RELATION_CF1 = "attends";
	static final String RELATION_CF2 = "fans";

	//收件箱表
	static final String INBOX_TABLE = "weibo:inbox";
	static final String INBOX_CF = "info";


}
