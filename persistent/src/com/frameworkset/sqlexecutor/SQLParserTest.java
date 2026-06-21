package com.frameworkset.sqlexecutor;
/**
 * Copyright 2026 bboss
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

import com.frameworkset.util.VariableHandler;
import org.frameworkset.persitent.util.APISQLStruction;
import org.frameworkset.persitent.util.SQLBaseCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author biaoping.yin
 * @Date 2026/1/14
 */
public class SQLParserTest {
    private static Logger logger = LoggerFactory.getLogger(SQLParserTest.class);
    public static void main(String[] args) {

        VariableHandler.SQLStruction sqlStruction = SQLBaseCache.evalSQLStruction("select * from test where id = ?");
        logger.info("");
        sqlStruction = SQLBaseCache.evalSQLStruction("select * from test where id = #[id,type=int,default=10,required=false,description=功能说明]");
        
        String sql = "select\n" +
                "#[api_id,alias=apiId,desc=应用id,column=true],\n" +
                "#[api_code,alias=apiCode,desc=应用编码,column=true],\n" +
                "#[api_name,alias=apiName,desc=应用名称,column=true],\n" +
                "#[api_url,alias=apiUrl,desc=应用地址,column=true]\n" +
                "from api_config\n" +
                "where api_type=#[apiType,type=string,default=1,required=false,desc=接口类型]";
        APISQLStruction apisqlStruction = SQLBaseCache.evalAPISQLStruction(sql);


        sql = "select * from api_config\n" +
                "where 1=1";
        apisqlStruction = SQLBaseCache.evalAPISQLStruction(sql);
        
        logger.info("");
    }

}
