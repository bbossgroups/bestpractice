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
import com.frameworkset.util.SimpleStringUtil;
import org.frameworkset.spi.assemble.PropertiesContainer;
import org.frameworkset.spi.assemble.PropertiesUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p></p>
 *
 * @author biaoping.yin
 * @Date 2023/12/27
 */
public class TestHttpClickHouseDB {
    @Test
    public   void testClickhouseBalanceRandom() throws SQLException {
//        SQLUtil.startPool("test",//数据源名称
//                "com.github.housepower.jdbc.ClickHouseDriver",//oracle驱动
//                "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops",//oracle rac链接串
//                "default",null,//数据库账号和口令
//                "select 1 " //数据库连接校验sql
//        );//初始化数据源

        DBConf tempConf = new DBConf();
        tempConf.setPoolname("test");
        tempConf.setDriver("com.clickhouse.jdbc.ClickHouseDriver");
        tempConf.setJdbcurl( "jdbc:clickhouse:http://10.13.6.4:28123,10.13.6.6:28123,10.13.6.7:28123/visualops?b.enableBalance=true&b.balance=roundbin");
        tempConf.setUsername("default");
        tempConf.setPassword("123456");
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
        tempConf.setExternal(false);
        tempConf.setEncryptdbinfo(false);
        boolean showsql = propertiesContainer.getBooleanProperty("showsql",true);
        tempConf.setShowsql(showsql);
        tempConf.setQueryfetchsize(null);
        tempConf.setEnableBalance(true);
        tempConf.setBalance(DBConf.BALANCE_RANDOM);
        SQLManager.startPool(tempConf);

        List<Map> datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));

        datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));

        datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));
        
        Object v = SQLExecutor.insert("insert into iops_out_call_result_stat(HANDLE_TIME) values(?)",new Date());
        System.out.println(v);
    }

    @Test
    public   void testClickhouseBalanceRoundbin() throws SQLException {
//        SQLUtil.startPool("test",//数据源名称
//                "com.github.housepower.jdbc.ClickHouseDriver",//oracle驱动
//                "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops",//oracle rac链接串
//                "default",null,//数据库账号和口令
//                "select 1 " //数据库连接校验sql
//        );//初始化数据源

        DBConf tempConf = new DBConf();
        tempConf.setPoolname("test");
        tempConf.setDriver("com.clickhouse.jdbc.ClickHouseDriver");
        tempConf.setJdbcurl( "jdbc:clickhouse:http://10.13.6.4:28123,10.13.6.6:28123,10.13.6.7:28123/visualops?b.enableBalance=true&b.balance=roundbin");
        tempConf.setUsername("default");
        tempConf.setPassword("123456");
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
        tempConf.setExternal(false);
        tempConf.setEncryptdbinfo(false);
        boolean showsql = propertiesContainer.getBooleanProperty("showsql",true);
        tempConf.setShowsql(showsql);
        tempConf.setQueryfetchsize(null);
        tempConf.setEnableBalance(true);
        tempConf.setBalance(DBConf.BALANCE_ROUNDBIN);
        SQLManager.startPool(tempConf);

        List<Map> datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));

        datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));

        datas = SQLExecutor.queryList(Map.class,"show tables");
        System.out.println(SimpleStringUtil.object2json(datas));
    }
    @Test
    public void test() throws SQLException {
//        String url = "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops";
//        DBClickhouse dbClickhouse = new DBClickhouse();
//        List<String> hostsL = dbClickhouse.getBalanceUrls(url);
//
//        System.out.println(SimpleStringUtil.object2json(hostsL));
//        url = "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/";
//
//        hostsL = dbClickhouse.getBalanceUrls(url);
//
//        System.out.println(SimpleStringUtil.object2json(hostsL));
//        url = "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000";
//        hostsL = dbClickhouse.getBalanceUrls(url);
//
//        System.out.println(SimpleStringUtil.object2json(hostsL));
//        Map<String,Object> p = dbClickhouse.getUrlParams(url);
//
//        System.out.println(SimpleStringUtil.object2json(p));
//
//        url = "jdbc:clickhouse://101.13.6.4:29000,101.13.6.7:29000,101.13.6.6:29000/visualops?b.balance=roundbin&b.enableBalance=true";
//        p = dbClickhouse.getUrlParams(url);
//
//        System.out.println(SimpleStringUtil.object2json(p));


    }
    
    

}
