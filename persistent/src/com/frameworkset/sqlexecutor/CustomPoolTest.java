package com.frameworkset.sqlexecutor;

import java.sql.SQLException;
import java.util.HashMap;
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
		SQLUtil.startPool("test","oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@(description=(address_list=(load_balance=off)(failover=on)(address=(protocol=tcp)(host=10.0.8.226)(port=1521))(address=(protocol=tcp)(host=10.0.8.227)(port=1521)))(connect_data=(service_name=PF1)(failover_mode=(type=select)(method=basic)(RETRIES=180)(DELAY=5))))","mdm","mdm_2015",
				 "select 1 from dual");
	}
	@Test
	public void initdata() throws SQLException
	{
		List<String> data = SQLExecutor.queryListWithDBName(String.class,"test","select MODULE_ID from TB_MODULE_INFO");
		int aid  =2000;
		for(String mid:data)
		{
			SQLExecutor.insertWithDBName("test", "insert into TB_MODULE_AUTH(AUTH_ID,ADMIN_ID,MODULE_ID) values(?,'22',?)", aid+"",mid);
			aid = aid+1;
		}
	}

}
