package com.timesontransfar.mfsp.util;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
 * MongoDB工具类：多数据源案例  
   * @ClassName: MultiMongosUtil
   * @Description: TODO
   * @author Kimi.Qin
   * @date Jun 23, 2016 3:26:05 PM
   *
 */
public abstract class MultiMongosUtil {
	private static Logger logger = LoggerFactory.getLogger(MultiMongosUtil.class);

    /**
     * 启动2个MongoDB数据源：testmg1，testmg2
     */
	public static void startDBs(){

        //数据源testmg1定义
		MongoDBConfig mongoDBConfig = new MongoDBConfig();
		mongoDBConfig.setName("testmg1");
//		mongoDBConfig.setCredentials(mongoDBInputConfig.getCredentials());
		mongoDBConfig.setUserName("bboss");
		mongoDBConfig.setPassword("bboss");
		mongoDBConfig.setAuthDb("sessions");
		mongoDBConfig.setMechanism("MONGODB-CR");
//		mongoDBConfig.setServerAddresses(mongoDBInputConfig.getServerAddresses());
		mongoDBConfig.setWriteConcern("JOURNAL_SAFE");//private String writeConcern;
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
		mongoDBConfig.setReadPreference("SECONDARY");//private String readPreference;

		mongoDBConfig.setConnectionsPerHost(100);//private int connectionsPerHost = 50;

		mongoDBConfig.setMaxWaitTime(120000);//private int maxWaitTime = 120000;
		mongoDBConfig.setSocketTimeout(120000);//private int socketTimeout = 0;
		mongoDBConfig.setConnectTimeout(120000);//private int connectTimeout = 15000;


		mongoDBConfig.setSocketKeepAlive(true);//private Boolean socketKeepAlive = false;

		mongoDBConfig.setConnectString("mongodb://192.168.137.1:27017,192.168.137.1:27018,192.168.137.1:27019/?replicaSet=rs0");
		boolean started = MongoDBHelper.init(mongoDBConfig);

        //数据源testmg2定义
        mongoDBConfig = new MongoDBConfig();
        mongoDBConfig.setName("testmg2");
//		mongoDBConfig.setCredentials(mongoDBInputConfig.getCredentials());
        mongoDBConfig.setUserName("bboss");
        mongoDBConfig.setPassword("bboss");
        mongoDBConfig.setAuthDb("sessions");
        mongoDBConfig.setMechanism("MONGODB-CR");
//		mongoDBConfig.setServerAddresses(mongoDBInputConfig.getServerAddresses());
        mongoDBConfig.setWriteConcern("JOURNAL_SAFE");//private String writeConcern;
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
        mongoDBConfig.setReadPreference("SECONDARY");//private String readPreference;

        mongoDBConfig.setConnectionsPerHost(100);//private int connectionsPerHost = 50;

        mongoDBConfig.setMaxWaitTime(120000);//private int maxWaitTime = 120000;
        mongoDBConfig.setSocketTimeout(120000);//private int socketTimeout = 0;
        mongoDBConfig.setConnectTimeout(120000);//private int connectTimeout = 15000;


        mongoDBConfig.setSocketKeepAlive(true);//private Boolean socketKeepAlive = false;

        mongoDBConfig.setConnectString("mongodb://192.168.137.2:27017,192.168.137.2:27018,192.168.137.2:27019/?replicaSet=rs0");
        started = MongoDBHelper.init(mongoDBConfig);


        MongoDatabase mongoDatabase = MongoDBHelper.getDB("testmg1",//指定MongoDB数据源名称：testmg1
                "useusu");//database;
        MongoCollection dbcollectoin  = MongoDBHelper.getDBCollection("testmg1",//指定MongoDB数据源名称：testmg1
                "useusu",//database
                "classes" //table
        );
	}

    public static void closeMongodb(){
        MongoDBHelper.closeDB("testmg2");
        MongoDBHelper.closeDB("testmg1");
    
    }
	/**
	 * 存储键值对到Redis中，并指定失效时间(秒)

	 * @throws Exception 
	 */
	public static void save()  {
		try {
            //在默认数据源上操作，第一个启动的MongoDB数据源为默认数据源，startDBs方法中第一个启动的数据源名称为：startDBs，所以默认为：testmg1
			MongoCollection dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
																	"classes" //table
					);
			MongoDB.remove(dbcollectoin, new BasicDBObject("name","一六班"));
			MongoDB.insert(dbcollectoin,new Document("name","一六班")
					.append("creationTime", new Date())
					.append("members",50)
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 
		}
	}

    /**
     * 新增数据测试

     * @throws Exception
     */
    public static void appendData()  {
        try {
            MongoCollection dbcollectoin  = MongoDBHelper.getDBCollection("testmg2",//指定MongoDB数据源名称：testmg2
                    "useusu",//database
                    "classes" //table
            );
            int i = 0;
            do {
//            MongoDB.remove(dbcollectoin, new BasicDBObject("name","一六班"));
                MongoDB.insert(dbcollectoin, new Document("name", "一六班-" + i)
                        .append("creationTime", new Date())
                        .append("members", 50)
                );
                i ++;
                Thread.sleep(1000L);
            }while (true);


        } catch (Exception e) {
            logger.error("",e);
        } finally {

        }
    }





    /**
	 * 获取并同时移除指定KEY，并返回结果
	 * @return
	 */
	public static String getAndRemove() {
		MongoCollection<Document> dbcollectoin  = MongoDBHelper.getDBCollection("testmg1",//指定MongoDB数据源名称：testmg1
                "useusu",//database
				"classes" //table
				);
		 
		String attribute = "name";//MongoDBHelper.converterSpecialChar( "name");//如果名称中包含mongodb关键字特殊字符，则需要进行转换
		 
		Document obj = dbcollectoin.findOneAndDelete(new BasicDBObject(attribute,"一六班-1"));//查询条件，返回所有字段
				
		if(obj == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder result = new StringBuilder();
		result.append("name=").append((String)obj.get(attribute)).append(",")
		.append("creationTime=").append(format.format((Date)obj.get("creationTime"))).append(",")
		.append("members=").append(obj.get("members"));
		
		return result.toString() ;
	}
	
	/**
	 * 获取指定KEY对应的VALUE
	 * @return
	 */
	public static String get() {
        //在默认数据源上操作，第一个启动的MongoDB数据源为默认数据源，startDBs方法中第一个启动的数据源名称为：startDBs，所以默认为：testmg1
		MongoCollection<Document> dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
				"classes" //table
				);
//		BasicDBObject keys = new BasicDBObject();//设置查询字段
		String attribute = "name";//MongoDBHelper.converterSpecialChar( "name");//如果名称中包含mongodb关键字特殊字符，则需要进行转换
//		keys.put(attribute, 1);
//		keys.put("creationTime", 1);
//		keys.put("members", 1);
		Bson projectionFields = Projections.fields(
				Projections.include(attribute,"creationTime","members")
					,Projections.excludeId()
		);
		Document obj = dbcollectoin.find(new BasicDBObject(attribute,"一六班")//查询条件

															 ).projection(projectionFields).first();
		if(obj == null)
			return null;		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder result = new StringBuilder();
		result.append("name=").append((String)obj.get(attribute)).append(",")
		.append("creationTime=").append(format.format((Date)obj.get("creationTime"))).append(",")
		.append("members=").append(obj.get("members"));
		
		return result.toString() ;
	}
	
	public static void main(String[] args)
	{

        startDBs();
        appendData();
        save();
		getAndRemove();

	}
	
	public static void runtest()
	{
		try {
			save();
//			System.out.println("get test:"+get());
//			System.out.println("getAndRemove test:"+getAndRemove());
//			System.out.println("get test after remove:"+get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
