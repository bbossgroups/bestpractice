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

import org.frameworkset.util.annotations.MapKey;
import org.frameworkset.util.annotations.RequestHeader;
import org.frameworkset.util.annotations.RequestParam;
import org.frameworkset.util.annotations.ResponseBody;
import org.frameworkset.web.servlet.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

	
}
