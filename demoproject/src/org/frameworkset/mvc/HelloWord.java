/**
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
package org.frameworkset.mvc;

import com.frameworkset.util.SimpleStringUtil;
import com.frameworkset.util.StringUtil;
import org.frameworkset.util.annotations.*;
import org.frameworkset.web.servlet.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * HelloWord.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * bboss workgroup
 * </p>
 * <p>
 * Copyright (c) 2009
 * </p>
 * 
 * @Date 2011-6-4
 * @author biaoping.yin
 * @version 1.0
 */
public class HelloWord
{
	private DataSource ds;
	public String sayHelloNumber(@RequestParam(name = "name",defaultvalue = "0") int ynum,
			ModelMap model) 
	{

		if (ynum != 0)
		{
			model.addAttribute("serverHelloNumber", "幸运数字为[" + ynum + "]！");
			
		}
		else
			model.addAttribute("serverHelloNumber", "幸运数字为[" + ynum
					+ "]！，好像有点不对哦。");

		return "path:sayHello";
	}

	public String sayHelloString(@RequestParam(name = "name") String yourname,
			ModelMap model)
	{

		if (yourname != null && !"".equals(yourname))
			model.addAttribute("serverHello", "服务器向您[" + yourname + "]问好！");
		else
			model.addAttribute("serverHello", "请输入您的名字！");
		return "path:sayHello";
	}

	public String sayHelloTime(
			@RequestParam(name = "d12", dateformat = "yyyy-MM-dd") java.util.Date d12,
			@RequestParam(name = "stringdate", dateformat = "yyyy-MM-dd") java.sql.Date stringdate,
			@RequestParam(name = "stringdatetimestamp", dateformat = "yyyy-MM-dd HH/mm/ss") java.sql.Timestamp stringdatetimestamp,
			@RequestParam(name = "stringdatetimestamp") String stringdatetimestamp_,
			ModelMap model)
	{

		model.put("utilDate", d12);
		model.put("sqlDate", stringdate);
		model.put("sqlTimestamp", stringdatetimestamp);
		return "path:sayHello";

	}
	
	public String sayHelloTimes(
			@RequestParam(name = "d12s", dateformat = "yyyy-MM-dd") java.util.Date[] d12,
			@RequestParam(name = "stringdates", dateformat = "yyyy-MM-dd") java.sql.Date[] stringdate,
			@RequestParam(name = "stringdatetimestamps", dateformat = "yyyy-MM-dd HH/mm/ss") java.sql.Timestamp[] stringdatetimestamp,
			@RequestParam(name = "stringdatetimestamps") String[] stringdatetimestamp_,
			ModelMap model)
	{
		if(d12 != null)
		{
			model.put("utilDates", d12[0]);
			model.put("sqlDates", stringdate[0]);
			model.put("sqlTimestamps", stringdatetimestamp[0]);
		}
		return "path:sayHello";

	}

	public String sayHelloBean(ExampleBean yourname, ModelMap model)
	{

		if (yourname.getName() != null && !"".equals(yourname.getName()))
			model.addAttribute("serverHelloBean", yourname);
		else
			;

		return "path:sayHello";
	}


    /**
     * http proxy post and get test api
     * @param yourname
     * @return
     */
    public @ResponseBody String sayHelloBeanHttp(ExampleBean yourname)
    {



        return SimpleStringUtil.object2json(yourname);
    }

    /**
     * http proxy request body custom container api
     * @param yourname
     * @return
     */
    public @ResponseBody CustomContainer<ExampleBean> sayHelloBodyHttp( @RequestBody ExampleBean yourname)
    {

        CustomContainer<ExampleBean> customContainer = new CustomContainer<>();
        List<ExampleBean> datas = new ArrayList<>();
        datas.add(yourname);
        customContainer.setDatas(datas);
        customContainer.setName("大河");
        return customContainer;
    }



    public String sayHelloBeanList(List<ExampleBean> yourname, ModelMap model)
	{

		model.addAttribute("serverHelloListBean", yourname);

		return "path:sayHello";
	}

	public String sayHelloBeanMap(@RequestParam(name = "name") String yourname,
			@MapKey("name") Map<String, ExampleBean> mapBeans, ModelMap model)
	{

		model.addAttribute("serverHelloMapBean", mapBeans.get(yourname));
		return "path:sayHello";
	}
	
	public String sayHelloArray(@RequestParam(name = "name") String[] yournames,ModelMap model)
	{
		model.addAttribute("serverHelloArray",yournames);
		return "path:sayHello";
	}
	
	/**
	 * 测试单个字符串向枚举类型值转换
	 * @param type
	 * @throws IOException
	 */
	public   @ResponseBody(charset="UTF-8") 
	String sayHelloEnum(@RequestParam(name="sex") SexType type) throws IOException
	{
		if(type != null)
		{
			if(type == SexType.F)
			{
				return "女";
			}
			else if(type == SexType.M)
			{
				return "男";
			}
			else if(type == SexType.UN)
			{
				return "未知";
			}
				
		}
		
		return "未知";
	}
	/**
	 * 测试单个字符串向枚举类型值转换
	 * @param types
	 * @throws IOException
	 */
	public  @ResponseBody(charset="UTF-8") 
	String  sayHelloEnums(@RequestParam(name="sex") SexType[] types) throws IOException
	{
		
		if(types != null)
		{
			if(types[0] == SexType.F)
			{
				
				return "女";
			}
			else if(types[0] == SexType.M)
			{
				
				return "男";
			}
			else if(types[0] == SexType.UN)
			{
				return "未知";
			}				
		}	
		return "未知";
	}
	
	public String index()
	{		
		return "path:sayHello";
	}
	
//	public @ResponseBody String jsonp(String callback)
//	{
//		return callback + "({\"symbol\" : \"IBM\", \"price\" : \"91.42\"})";
//	}
	public @ResponseBody(datatype="jsonp") JsonpBean jsonp()
	{
		JsonpBean jsonpbean = new JsonpBean();
		jsonpbean.setPrice("91.42");
		jsonpbean.setSymbol("IBM");
		return jsonpbean;
	}
//	public @ResponseBody String jsonpwithjquery(String callback)
//	{
//		return callback + "({\"symbol\" : \"IBM jquery jsonp\", \"price\" : \"91.42\"})";
//	}
	
	public @ResponseBody(datatype="jsonp") JsonpBean jsonpwithjquery()
	{
		JsonpBean jsonpbean = new JsonpBean();
		jsonpbean.setPrice("91.42");
		jsonpbean.setSymbol("IBM jquery jsonp");
		return jsonpbean;
//		return callback + "({\"symbol\" : \"IBM jquery jsonp\", \"price\" : \"91.42\"})";
	}

	public @ResponseBody(datatype="jsonp") JsonpBean testLong(@RequestParam(defaultvalue = "0") long testId)
	{
		JsonpBean jsonpbean = new JsonpBean();
		jsonpbean.setPrice("91.42");
		jsonpbean.setSymbol("IBM jquery jsonp:"+testId);
		return jsonpbean;
//		return callback + "({\"symbol\" : \"IBM jquery jsonp\", \"price\" : \"91.42\"})";
	}

	public @ResponseBody String testTraceHeader(@RequestHeader(name="Pinpoint-TraceID") String traceId,//通过mvc请求头注解中获取链路跟踪id
												HttpServletRequest request){
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){//遍历所有的请求头，查看所有和链路跟踪id相关的head头部信息
			String name = names.nextElement();
			System.out.println(name+":"+request.getHeader(name));
		}
		String traceIdFromRequest = request.getHeader("Pinpoint-TraceID");//直接从request中获取Pinpoint-TraceID

		return "Pinpoint-TraceID："+traceId;

	}
	public @ResponseBody Map getData(){
		String data = "{\n" +
				"\t\"isSuccess\": true,\n" +
				"\t\"errorCode\": \"\",\n" +
				"\t\"errorMessage\": \"\",\n" +
				"\t\"returnObject\": [{\n" +
				"\t\t\"id\": 1001,\n" +
				"\t\t\"code\": \"huodong\",\n" +
				"\t\t\"title\": \"最新活动在这里哈\",\n" +
				"\t\t\"startDate\": \"2017/08/08\",\n" +
				"\t\t\"endDate\": \"2017/08/20\",\n" +
				"\t\t\"icon\": \"http://images.cnblogs.com/cnblogs_com/xingxiangyi/1065437/o_timg.jpg\",\n" +
				"\t\t\"viewer\": 301\n" +
				"\t},\n" +
				"\t{\n" +
				"\t\t\"id\": 1002,\n" +
				"\t\t\"code\": \"huodong\",\n" +
				"\t\t\"title\": \"全民来瑜伽\",\n" +
				"\t\t\"startDate\": \"2017/07/08\",\n" +
				"\t\t\"endDate\": \"2017/07/20\",\n" +
				"\t\t\"icon\": \"http://images.cnblogs.com/cnblogs_com/xingxiangyi/1065437/o_timg.jpg\",\n" +
				"\t\t\"viewer\": 101\n" +
				"\t}\n" +
				"\t]\n" +
				"}";
		return StringUtil.json2Object(data,Map.class);
	}

	
}
