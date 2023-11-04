package com.timesontransfar.mfsp.util;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.frameworkset.nosql.mongodb.MongoDB;
import org.frameworkset.nosql.mongodb.MongoDBConfig;
import org.frameworkset.nosql.mongodb.MongoDBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Redis工具类  
   * @ClassName: RedisUtil
   * @Description: TODO
   * @author Kimi.Qin
   * @date Jun 23, 2016 3:26:05 PM
   *
 */
public abstract class MongoInit {
	private static Logger logger = LoggerFactory.getLogger(MongoInit.class);

	
	public static void main(String[] args)
	{
		startDB();

	}
	public static void startDB(){

		/**
		 * 	    mongoDBOutputConfig.setName("testes2mg")
		 * 			    .setDb("testdb1")
		 * 			    .setDbCollection("demo")
		 * 			    .setConnectTimeout(10000)
		 * 			    .setWriteConcern("JOURNAL_SAFE")
		 *
		 * 			    .setMaxWaitTime(10000)
		 * 			    .setSocketTimeout(1500).setSocketKeepAlive(true)
		 * 			    .setConnectionsPerHost(10)
		 * 			    .setConnectString("mongodb://192.168.137.1:27017,192.168.137.1:27018,192.168.137.1:27019/?replicaSet=rs0")//多个地址用回车换行符分割：127.0.0.1:27017\n127.0.0.1:27018
		 * 	    // mechanism 取值范围：PLAIN GSSAPI MONGODB-CR MONGODB-X509，默认为MONGODB-CR
		 * 	    //String database,String userName,String password,String mechanism
		 * 	    //https://www.iteye.com/blog/yin-bp-2064662
		 * //				.setUserName("bboss")
		 * //		        .setPassword("bboss")
		 * //		        .setMechanism("MONGODB-CR");
		 */
		MongoDBConfig mongoDBConfig = new MongoDBConfig();
		mongoDBConfig.setName("testes2mg")
				.setUserName("bboss")
				.setPassword("bboss")
				.setAuthDb("sessions")
				.setMechanism("PLAIN")
//		.setServerAddresses(mongoDBInputConfig.getServerAddresses());
		.setWriteConcern("JOURNAL_SAFE")//private String writeConcern;
		/**
		 * if (readPreference.equals("PRIMARY"))
		 * 			return ReadPreference.primary();
		 * 		else if (readPreference.equals("SECONDARY"))
		 * 			return ReadPreference.secondary();
		 * 		else if (readPreference.equals("SECONDARY_PREFERRED"))
		 * 			return ReadPreference.secondaryPreferred();
		 * 		else if (readPreference.equals("PRIMARY_PREFERRED"))
		 * 			return ReadPreference.primaryPreferred();
		 * 		else if (readPreference.equals("NEAREST"))
		 * 			return ReadPreference.nearest();
		 */
		.setReadPreference("SECONDARY")//private String readPreference;

		.setConnectionsPerHost(100)//private int connectionsPerHost = 50;

		.setMaxWaitTime(120000)//private int maxWaitTime = 120000;
		.setSocketTimeout(120000)//private int socketTimeout = 0;
		.setConnectTimeout(120000)//private int connectTimeout = 15000;


		.setSocketKeepAlive(true)//private Boolean socketKeepAlive = false;

		.setConnectString("mongodb://192.168.137.1:27017,192.168.137.1:27018,192.168.137.1:27019/?replicaSet=rs0");
		boolean started = MongoDBHelper.init(mongoDBConfig);// started true标识数据源成功启动，false 标识数据源没有启动，可能已经启动过了，可能启动失败

	}

}
