package com.frameworkset.sqlexecutor;

import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.common.poolman.util.SQLManager;
import com.frameworkset.common.poolman.util.SQLUtil;
import com.frameworkset.util.ListInfo;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Map;

public class CustomMysqlPoolTest {
    private static Logger logger = LoggerFactory.getLogger(CustomMysqlPoolTest.class);
	public CustomMysqlPoolTest() {
		// TODO Auto-generated constructor stub
	}
	 @Before
	public   void init()
	{
        SQLUtil.startPool("test",//数据源名称  
                "com.mysql.cj.jdbc.Driver",//oracle驱动  
                "jdbc:mysql://localhost:3306/bboss?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true",//mysql链接串  
                "root","123456",//数据库账号和口令  
                "select 1 " //数据库连接校验sql  
        );
    }
    @Test
    public void query() throws SQLException {
        int d = SQLExecutor.queryObjectWithDBName(int.class,"test","select 1");
        logger.info("query result:{}",d);
    }
    @Test
    public void queryMoreQuery() throws SQLException {
        ListInfo d = SQLExecutor.moreListInfoWithDBName(Map.class,"test","select 1",0,2);
        logger.info("query result:{}",d);
    }
    @Test
    public void testGetDbAdapter(){
        SQLManager.getInstance().getDBAdapter("ddddd");
    }

}
