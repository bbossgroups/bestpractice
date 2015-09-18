package com.frameworkset.sqlexecutor;

import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.common.poolman.util.SQLUtil;

public class CustomPoolTest {

	public CustomPoolTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public static void init()
	{
		SQLUtil.startPool("test","oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@(description=(address_list=(load_balance=off)(failover=on)"
				+ "(address=(protocol=tcp)(host=10.0.8.226)(port=1521))(address=(protocol=tcp)(host=10.0.8.227)(port=1521)))"
				+ "(connect_data=(service_name=PF1)(failover_mode=(type=select)(method=basic)(RETRIES=180)(DELAY=5))))",
				"mdm","Y6^21rtDFuTYEWR#s",
				 "select 1 from dual");//初始化数据源
	}
	@Test
	public void initdata() throws SQLException
	{
		List<String> data = SQLExecutor.queryListWithDBName(String.class,"test","select MODULE_ID from TB_MODULE_INFO where MODULE_URL like '%/CrmAccount/%'");
		int aid  =SQLExecutor.queryObjectWithDBName(int.class, "test","select max(to_number(AUTH_ID)) from TB_MODULE_AUTH");
		aid ++;
		for(String mid:data)
		{
			SQLExecutor.insertWithDBName("test", "insert into TB_MODULE_AUTH(AUTH_ID,ADMIN_ID,MODULE_ID) values(?,'23',?)", aid+"",mid);//'22'是管理账号的id，对应于TD_USER_ADMIN表的SEQNO的值
			aid = aid+1;
		}
		
		SQLExecutor.insertWithDBName("test", "insert into TB_MODULE_AUTH(AUTH_ID,ADMIN_ID,MODULE_ID) values(?,'23',?)", aid+"","11");///SanyUIMPC/page/SanyAccount/orgTree.jsp
	}

}
