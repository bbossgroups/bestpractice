package com.timesontransfar.mfsp.util;

import org.frameworkset.nosql.redis.RedisFactory;
import org.frameworkset.nosql.redis.RedisHelper;

/**
 * Redis工具类  
   * @ClassName: RedisUtil
   * @Description: TODO
   * @author Kimi.Qin
   * @date Jun 23, 2016 3:26:05 PM
   *
 */
public abstract class CacheUtil {
	
	/**
	 * 存储键值对到Redis中，并指定失效时间(秒)
	 * @param key
	 * @param value
	 * @param seconds
	 * @throws Exception 
	 */
	public static void save(String key, String value, int seconds) throws Exception {
		RedisHelper redisHelper = null;
		try {
			redisHelper = RedisFactory.getRedisHelper();
			redisHelper.setex(key, seconds, value); //设置KEY-VALUE,指定时间
		} catch (Exception e) {
			throw e ;
		} finally {
			if (redisHelper != null) {
				redisHelper.release();
			}
		}
	}
	
	private static Object lock = new Object();
	/**
	 * 获取并同时移除指定KEY，并返回结果
	 * @param key
	 * @return
	 */
	public static String getAndRemove(String key) {
		String result = null ;
		RedisHelper redisHelper = null;
		try {
			redisHelper = RedisFactory.getRedisHelper();
			synchronized(lock)
			{
				result = redisHelper.get(key); //获取结果
				if(result != null){
					redisHelper.del(key); //移除KEY
				}
			}
		} catch (Exception e) {
			result = null ;
		} finally {
			if (redisHelper != null) {
				redisHelper.release();
			}
		}
		return result ;
	}
	
	/**
	 * 获取指定KEY对应的VALUE
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		String result = null ;
		RedisHelper redisHelper = null;
		try {
			redisHelper = RedisFactory.getRedisHelper();
			result = redisHelper.get(key); //获取结果
		} catch (Exception e) {
			result = null ;
		} finally {
			if (redisHelper != null) {
				redisHelper.release();
			}
		}
		return result ;
	}
	
	public static void main(String[] args)
	{
		try {
			save("test", "test123456", 60);
			System.out.println("get test:"+get("test"));
			System.out.println("getAndRemove test:"+getAndRemove("test"));
			System.out.println("get test:"+get("test"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
