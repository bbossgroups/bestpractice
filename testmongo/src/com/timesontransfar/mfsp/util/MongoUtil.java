package com.timesontransfar.mfsp.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.frameworkset.nosql.mongodb.MongoDB;
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
public abstract class MongoUtil {
	private static Logger logger = LoggerFactory.getLogger(MongoUtil.class);
	/**
	 * 存储键值对到Redis中，并指定失效时间(秒)

	 * @throws Exception 
	 */
	public static void save() throws Exception {
		try {
			DBCollection dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
																	"classes" //table
					);
			MongoDB.remove(dbcollectoin, new BasicDBObject("name","一六班"));
			MongoDB.insert(dbcollectoin,new BasicDBObject("name","一六班")
					.append("creationTime", new Date())
					.append("members",50)
					);
			
		} catch (Exception e) {
			throw e ;
		} finally {
			 
		}
	}

    /**
     * 存储键值对到Redis中，并指定失效时间(秒)

     * @throws Exception
     */
    public static void appendData()  {
        try {
            DBCollection dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
                    "classes" //table
            );
            int i = 0;
            do {
//            MongoDB.remove(dbcollectoin, new BasicDBObject("name","一六班"));
                MongoDB.insert(dbcollectoin, new BasicDBObject("name", "一六班-" + i)
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
	 * @param key
	 * @return
	 */
	public static String getAndRemove() {
		DBCollection dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
				"classes" //table
				);
		 
		String attribute = "name";//MongoDBHelper.converterSpecialChar( "name");//如果名称中包含mongodb关键字特殊字符，则需要进行转换
		 
		DBObject obj = dbcollectoin.findAndRemove(new BasicDBObject(attribute,"一六班"));//查询条件，返回所有字段
				
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
	 * @param key
	 * @return
	 */
	public static String get() {
		DBCollection dbcollectoin  = MongoDBHelper.getDBCollection("useusu",//database
				"classes" //table
				);
		BasicDBObject keys = new BasicDBObject();//设置查询字段
		String attribute = "name";//MongoDBHelper.converterSpecialChar( "name");//如果名称中包含mongodb关键字特殊字符，则需要进行转换
		keys.put(attribute, 1);
		keys.put("creationTime", 1);
		keys.put("members", 1);
		DBObject obj = dbcollectoin.findOne(new BasicDBObject(attribute,"一六班")//查询条件
															 ,keys //只返回需要查询的字段
															 );
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
//		System.out.println("run first time---------------------");
//		runtest();
//		System.out.println("run second time---------------------");
//		runtest();
//		System.out.println("run third time---------------------");
//		runtest();
//		System.out.println("run fourth time---------------------");
//		runtest();
//		System.out.println("run five time---------------------");
//		for(int i = 0; i < 100; i ++)
//		{
//			runtest();
//		}

        appendData();
		
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
