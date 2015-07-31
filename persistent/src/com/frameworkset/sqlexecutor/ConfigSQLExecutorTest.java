/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.frameworkset.sqlexecutor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.frameworkset.common.poolman.ConfigSQLExecutor;
import com.frameworkset.common.poolman.SQLParams;

public class ConfigSQLExecutorTest {
	private ConfigSQLExecutor executor ;
	@Before
	public void init()
	{
		executor = new ConfigSQLExecutor("com/frameworkset/sqlexecutor/sqlfile.xml");
		try {
			String sql = executor.getSql("sqltemplate");
			sql = executor.getSql("bspf","sqltemplate");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void queryMap() throws SQLException
	{
		
		
		Map dbBeans  =  executor.queryObject(HashMap.class, "sqltest");
		System.out.println(dbBeans);
	}
	
	
	@Test
	public void queryField() throws SQLException
	{
		 ListBean bean = new ListBean();
		    bean.setFieldName("阿斯顿飞");
		 //<property name="refresh_interval" value="10000"/>
		 String result = executor.queryFieldBean("sqltemplate", bean);
		 System.out.println(result);
		 
		 result = executor.queryFieldBean("sqltemplate", bean);
		 System.out.println(result);
		 
	}
	
	@Test
	public void dynamicquery() throws SQLException
	{
		 ListBean bean = new ListBean();
		    bean.setFieldName("阿斯顿飞");
		 //<property name="refresh_interval" value="10000"/>
		 List<ListBean> result = executor.queryListBean(ListBean.class, "dynamicsqltemplate", bean);
		 System.out.println(result.size());
		  bean.setFieldName("");
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplate", bean);
		 System.out.println(result.size());
		 
		 bean.setFieldName(null);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplate", bean);
		 System.out.println(result.size());
		 
	}
	
	@Test
	public void dynamicqueryWithSQLParams() throws SQLException
	{
		 SQLParams params = new SQLParams();
		 params.addSQLParam("fieldName", "阿斯顿飞", SQLParams.STRING);
		 
		 //<property name="refresh_interval" value="10000"/>
		 List<ListBean> result = executor.queryListBean(ListBean.class, "dynamicsqltemplate", params);
		 System.out.println(result.size());
		 params = new SQLParams();
		 params.addSQLParam("fieldName", "", SQLParams.STRING);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplate", params);
		 System.out.println(result.size());
		 
		 params = new SQLParams();
		 params.addSQLParam("fieldName", null, SQLParams.STRING);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplate", params);
		 System.out.println(result.size());
		 
	}
	
	
	@Test
	public void dynamicqueryidWithbean() throws SQLException
	{
		 ListBean bean = new ListBean();
		    bean.setId(139);
		 //<property name="refresh_interval" value="10000"/>
		 List<ListBean> result = executor.queryListBean(ListBean.class, "dynamicsqltemplateid", bean);
		 System.out.println(result.size());
		  bean.setId(-1);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplateid", bean);
		 System.out.println(result.size());
		 
		 bean.setId(0);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplateid", bean);
		 System.out.println(result.size());
		 
	}
	@Test
	public void dynamicqueryidWithSQLParams() throws SQLException
	{
		 
		    
		 SQLParams params = new SQLParams();
		 params.addSQLParam("id", 139, SQLParams.INT);
		 //<property name="refresh_interval" value="10000"/>
		 List<ListBean> result = executor.queryListBean(ListBean.class, "dynamicsqltemplateid", params);
		 System.out.println(result.size());
		 params = new SQLParams();
		 params.addSQLParam("id", -1, SQLParams.INT);
		 result = (List<ListBean>) executor.queryListBean(ListBean.class,"dynamicsqltemplateid", params);
		 System.out.println(result.size());
		 params = new SQLParams();
		 params.addSQLParam("id", 0, SQLParams.INT);
		 result = (List<ListBean>) executor.queryListBeanWithDBName(ListBean.class,"cim","dynamicsqltemplateid", params);
//		 result = (List<ListBean>) SQLExecutor.queryListBeanWithDBName(ListBean.class,"dbname","sql", params);
		 System.out.println(result.size());
		 
	}
	
	
	@Test
	public void updateWithSQLParams() throws SQLException
	{
		 
		    
		 SQLParams params = new SQLParams();
		 params.addSQLParam("id", 139, SQLParams.INT);
		 params.addSQLParam("fieldName", "duoduo139", SQLParams.STRING);
		 List<SQLParams> params_ = new ArrayList<SQLParams>(2);
		 params_.add(params);
		 //<property name="refresh_interval" value="10000"/>
		 
		 
		 params = new SQLParams();
		 params.addSQLParam("id", 140, SQLParams.INT);
		 params.addSQLParam("fieldName", "duoduo140", SQLParams.STRING);
		 params_.add(params);
		
		 params = new SQLParams();
		 params.addSQLParam("id", 141, SQLParams.INT);
		 
		 params.addSQLParam("fieldName", "duoduo141", SQLParams.STRING);
		 params_.add(params);
		 executor.updateBeans("updatesqltemplate", params_);		 
//		 result = (List<ListBean>) SQLExecutor.queryListBeanWithDBName(ListBean.class,"dbname","sql", params);
//		 System.out.println(result.size());
		 
	}
	
	@Test
	public void updateWithMapParams() throws SQLException
	{
		 
		 Map datas = new HashMap();
		 datas.put("id", 139);
		 datas.put("fieldName", "updateWithMapParams139");
		 List<Map> params_ = new ArrayList<Map>();
		 params_.add(datas);
		 datas = new HashMap();
		 datas.put("id", 140);
		 datas.put("fieldName", "updateWithMapParams140");
		 params_.add(datas);		
		 datas = new HashMap();
		 datas.put("id", 141);
		 datas.put("fieldName", "updateWithMapParams141");
		 params_.add(datas);		
		 executor.updateBeans("updatesqltemplate", params_);		 
//		 result = (List<ListBean>) SQLExecutor.queryListBeanWithDBName(ListBean.class,"dbname","sql", params);
//		 System.out.println(result.size());
		 
	}

}
