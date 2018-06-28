package com.frameworkset.sqlexecutor;/*
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

import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.common.poolman.util.SQLUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ESJdbcTest {
	private void initDBSource(){
		SQLUtil.startPool("es",//数据源名称
				"org.elasticsearch.xpack.sql.jdbc.jdbc.JdbcDriver",//oracle驱动
				"jdbc:es://http://127.0.0.1:9200/timezone=UTC&page.size=250",//mysql链接串
				"elastic","changeme",//数据库账号和口令
				"" //数据库连接校验sql
		);
	}
	@Test
	public void test() throws SQLException {
		initDBSource();
	 List<HashMap> data =	SQLExecutor.queryListWithDBName(HashMap.class,"es","SELECT SCORE() as score,content as content FROM dbclobdemo");
	 System.out.println(data);
	}
}
