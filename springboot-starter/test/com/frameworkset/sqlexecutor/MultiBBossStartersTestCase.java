/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.frameworkset.sqlexecutor;


import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.util.SimpleStringUtil;
import org.frameworkset.spi.remote.http.HttpRequestProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * testCase必须和spring boot application启动类在同一个包路径下面，否则会报错：
 * java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @Context
 * 多集群演示功能测试用例，spring boot配置项以spring.bboss.集群名称开头，例如：
 * spring.bboss.db.firstds
 * spring.bboss.db.secondds
 *  spring.bboss.http.default
 *  spring.bboss.http.second
 * 两个集群通过  com.frameworkset.sqlexecutor.MultiSTartConfigurer
 * 对应的配置文件为application-multi.properties文件
 * @author yinbp [122054810@qq.com]
 */
@RunWith(SpringRunner.class)
@SpringBootTest

@ActiveProfiles("multi")
public class MultiBBossStartersTestCase {
	@Autowired
	private Db2DBdemo db2DBdemo;
	private static Logger logger = LoggerFactory.getLogger(MultiBBossStartersTestCase.class);
    @Test
    public void testMultiBBossESStarterDefault() throws Exception {
		Map params = new HashMap();
		params.put("testp","aaaaa");
		params.put("dff","zzzz");
		List<Map> datas = HttpRequestProxy.httpPostForList("default","/demoproject/file/getUserInfo.page",params,Map.class);
		logger.info(SimpleStringUtil.object2json(datas));
    }

	@Test
	public void testMultiBBossESStarterSecond() throws Exception {
		Map params = new HashMap();
		params.put("testp","aaaaa");
		params.put("dff","zzzz");
		List<Map> datas = HttpRequestProxy.sendJsonBodyForList("second",params,"/demoproject/file/getUserInfo.page",Map.class);
		logger.info(SimpleStringUtil.object2json(datas));
	}

	@Test
	public void testFirstQuery() throws Exception {

		List<Map> datas = SQLExecutor.queryListWithDBName(Map.class,"firstds","select * from user");
		logger.info(SimpleStringUtil.object2json(datas));
	}

	@Test
	public void testSecondQuery() throws Exception {

		List<Map> datas = SQLExecutor.queryListWithDBName(Map.class,"secondds","select * from user");
		logger.info(SimpleStringUtil.object2json(datas));
	}
	@Test
	public void scheduleImportData(){
		db2DBdemo.scheduleImportData();


	}
}
