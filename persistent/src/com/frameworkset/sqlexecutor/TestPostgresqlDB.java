package com.frameworkset.sqlexecutor;
/**
 * Copyright 2023 bboss
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.common.poolman.util.DBConf;
import com.frameworkset.common.poolman.util.SQLManager;
import com.frameworkset.orm.adapter.DBClickhouse;
import com.frameworkset.util.ListInfo;
import com.frameworkset.util.SimpleStringUtil;
import org.frameworkset.spi.assemble.PropertiesContainer;
import org.frameworkset.spi.assemble.PropertiesUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p></p>
 *
 * @author biaoping.yin
 * @Date 2023/12/27
 */
public class TestPostgresqlDB {
    @Test
    public   void testDB() throws SQLException {
//        SQLUtil.startPool("test",//数据源名称
//                "com.github.housepower.jdbc.ClickHouseDriver",//oracle驱动
//                "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops",//oracle rac链接串
//                "default",null,//数据库账号和口令
//                "select 1 " //数据库连接校验sql
//        );//初始化数据源
        DBConf tempConf = new DBConf();
        tempConf.setPoolname("test");
        tempConf.setDriver("org.postgresql.Driver");
        tempConf.setJdbcurl( "jdbc:postgresql://10.19.32.210:5432/postgres");
        tempConf.setUsername("postgres");
        tempConf.setPassword("1qazPostgres");
        tempConf.setValidationQuery("select 1 ");
        //tempConf.setTxIsolationLevel("READ_COMMITTED");
        tempConf.setJndiName("jndi-test");
        PropertiesContainer propertiesContainer = PropertiesUtil.getPropertiesContainer();
        int initialConnections = propertiesContainer.getIntProperty("initialConnections",5);
        tempConf.setInitialConnections(initialConnections);
        int minimumSize = propertiesContainer.getIntProperty("minimumSize",5);
        tempConf.setMinimumSize(minimumSize);
        int maximumSize = propertiesContainer.getIntProperty("maximumSize",10);
        tempConf.setMaximumSize(maximumSize);
        tempConf.setUsepool(true);
 
        boolean showsql = propertiesContainer.getBooleanProperty("showsql",true);
        tempConf.setShowsql(showsql);
        tempConf.setQueryfetchsize(null);
  
      
        SQLManager.startPool(tempConf);
        List<Map> ddd = SQLExecutor.queryList(Map.class,"select * from public.langchain_pg_embedding offset ? limit ? ",0,1);
        System.out.println(SimpleStringUtil.object2json(ddd));
        ListInfo datas = SQLExecutor.queryListInfo(Map.class,"select * from public.langchain_pg_embedding  ",0,2);
        System.out.println(SimpleStringUtil.object2json(datas));
        List<Map> ss = SQLExecutor.queryList(Map.class," select * from (SELECT (1 - (embedding <=> '[3,1,2]')) AS cosine_similarity FROM public.items) where cosine_similarity > 0.8");

        System.out.println(SimpleStringUtil.object2json(ss));
    }

    @Test
    public   void testDBPanwei() throws SQLException {
//        SQLUtil.startPool("test",//数据源名称
//                "com.github.housepower.jdbc.ClickHouseDriver",//oracle驱动
//                "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops",//oracle rac链接串
//                "default",null,//数据库账号和口令
//                "select 1 " //数据库连接校验sql
//        );//初始化数据源

        DBConf tempConf = new DBConf();
        tempConf.setPoolname("test");
        tempConf.setDriver("org.postgresql.Driver");
        tempConf.setJdbcurl( "jdbc:postgresql://10.13.6.127:17700/visualops?currentSchema=visualops");
        tempConf.setUsername("baseadmin");
        tempConf.setPassword("&xxXzz3139%**");
        tempConf.setValidationQuery("select 1 ");
        //tempConf.setTxIsolationLevel("READ_COMMITTED");
        tempConf.setJndiName("jndi-test");
        PropertiesContainer propertiesContainer = PropertiesUtil.getPropertiesContainer();
        int initialConnections = propertiesContainer.getIntProperty("initialConnections",5);
        tempConf.setInitialConnections(initialConnections);
        int minimumSize = propertiesContainer.getIntProperty("minimumSize",5);
        tempConf.setMinimumSize(minimumSize);
        int maximumSize = propertiesContainer.getIntProperty("maximumSize",10);
        tempConf.setMaximumSize(maximumSize);
        tempConf.setUsepool(true);

        boolean showsql = propertiesContainer.getBooleanProperty("showsql",true);
        tempConf.setShowsql(showsql);
        tempConf.setQueryfetchsize(null);


        SQLManager.startPool(tempConf);
        List<Map> ddd = SQLExecutor.queryList(Map.class,"select * from webdetector_url offset ? limit ? ",0,1);
        System.out.println(SimpleStringUtil.object2json(ddd));
        ListInfo datas = SQLExecutor.queryListInfo(Map.class,"select * from webdetector_url",0,2);
        System.out.println(SimpleStringUtil.object2json(datas));

    }
    

     
    

}
