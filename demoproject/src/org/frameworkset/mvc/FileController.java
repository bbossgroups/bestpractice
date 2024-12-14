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

import com.frameworkset.common.poolman.SQLExecutor;
import com.frameworkset.util.StringUtil;
import org.frameworkset.http.FileBlob;
import org.frameworkset.log.LogBiz;
import org.frameworkset.spi.InitializingBean;
import org.frameworkset.spi.remote.http.HttpRequestProxy;
import org.frameworkset.util.annotations.RequestBody;
import org.frameworkset.util.annotations.ResponseBody;
import org.frameworkset.web.multipart.IgnoreFieldNameMultipartFile;
import org.frameworkset.web.multipart.MultipartFile;
import org.frameworkset.web.servlet.ModelMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * <p> FileController.java</p>
 * <p> Description: </p>
 * <p> bboss workgroup </p>
 * <p> Copyright (c) 2009 </p>
 * 
 * @Date 2012-5-14 下午3:25:35
 * @author biaoping.yin
 * @version 1.0
 */
public class FileController implements InitializingBean {

	public static String getWorkFoldPath()
	{
		return org.frameworkset.web.servlet.support.WebApplicationContextUtils.getWebApplicationContext().getProperty("file.workfolder");
	}
	private String filedomain;
	private String rootPath;
	public String fileupload()
	{
		return "path:fileupload";
	}
	
	public String foldertree()
	{
		LogBiz logBiz = new LogBiz();
		String traceId = "";
		Map log = new HashMap();
		log.put("modulename","demoproject");
		log.put("servicename","filecontroller");
		log.put("mainservice",true);
		log.put("phonenumber","18175197562");
		log.put("operid","76010");
		log.put("starttime",System.currentTimeMillis());
		log.put("costtime",10);
		log.put("errlog","错误日志");
		log.put("bizstatus","0");
		log.put("subbizstatus","22");
		log.put("bizstatusdesc","子状态描述");
		log.put("endtime",System.currentTimeMillis());
		log.put("ext","入参");
		log.put("probetype","web");
//		log.put("apmBizId","demoproject");
//		log.put("apmBizSessionId","qwerqwerqer");
		log.put("bizId","demoproject");
		log.put("bizSessionId","qwerqwerqer");

		logBiz.log(log);
		return "path:foldertree";
	}
	public String filelist(String uri,ModelMap model) throws Exception
	{
		if(uri == null)
			uri = "";
		List files = getDirectoryResource(uri);
		model.addAttribute("files", files);
		return "path:filelist";
	}
	public @ResponseBody String mkdir(String workfolder,String uri)
	{
		
		File file = new File(rootPath,workfolder);
		boolean s = false;
		if(!file.exists())
		{
			
			file.mkdirs();
		}
		File d = new File(file.getAbsolutePath(),uri);
		if(!d.exists())
		{
			
			s = d.mkdirs();
		}
		return s?"success":"fail";
			
	}
	public List getDirectoryResource(String uri)
			throws Exception {
		
		List fileResources = new ArrayList();
		File[] subFiles = FileUtil.getSubFiles(rootPath, uri);
		for (int i = 0; subFiles != null && i < subFiles.length; i++) {
			FileResource fr = new FileResource();
			String theURI = "";
			if (uri != null && uri.trim().length() != 0) {
				uri = uri.replace('\\', '/');
				if (!uri.endsWith("/")) {
					theURI = uri + "/";
				} else {
					theURI = uri;
				}
				if (theURI.trim().equals("/")) {
					theURI = "";
				}
			}
			fr.setUri(filedomain + theURI + subFiles[i].getName());			
			fr.setName(subFiles[i].getName());
			fr.setSize(subFiles[i].length());
			fr.setModifyTime(new Date(subFiles[i].lastModified()));
			fileResources.add(fr);
		}
		return fileResources;
	}
	
	public String uptable()
	{
		return "path:uptable";
	}
	public @ResponseBody String uploadFiles(IgnoreFieldNameMultipartFile[] filedata,boolean overide ,String workfolder)
	{
		File file = new File(rootPath,workfolder);
		StringBuffer msg = new StringBuffer(); 
		for(int i =0; filedata != null && i < filedata.length; i ++)
		{
			MultipartFile file_ = filedata[i];
			File f = new File(file.getAbsolutePath(),file_.getOriginalFilename());
			if(f.exists() && !overide)
			{
				continue;
			}
			else
			{
				try {
					file_.transferTo(f);
				} catch (Exception e) {
					msg.append(StringUtil.formatBRException(e));
				}
			}
		}
		
		if(msg.length() == 0)
			return "success";
		else
			return msg.toString();
	}
	
	
	public @ResponseBody String upload(IgnoreFieldNameMultipartFile[] filedata,String testparam) throws IllegalStateException, IOException
	{
		if(filedata != null)
		{
			filedata[0].transferTo(new File("d:/tst.png"));
		}
		return "{\"err\":\"\",\"msg\":\"tst.png\"}";
	}
	
	public @ResponseBody String uploadwithbean(FileBean filedata,String testparam) throws IllegalStateException, IOException
	{
		if(filedata != null)
		{
			filedata.getFile().transferTo(new File("d:/tst.png"));
		}
		return "{\"err\":\"\",\"msg\":\"tst.png\"}";
	}

	public @ResponseBody List<Map> getUserInfo(String testp,String dff) throws SQLException {
		System.out.println("testp:"+testp);
		System.out.println("dff:"+dff);
		return SQLExecutor.queryList(Map.class,"select * from user");
//		return SQLExecutor.queryList(Map.class,"select * from td_sm_user where user_id = ?",1000);
//		return SQLExecutor.queryList(Map.class,"select * from td_sm_user");
	}

	public @ResponseBody List<Map> jsonUserInfo(@RequestBody Map params) throws SQLException {
		System.out.println("params:"+params);
//		return new ArrayList<>();
		return SQLExecutor.queryList(Map.class,"select * from user");
//		return SQLExecutor.queryList(Map.class,"select * from td_sm_user");
	}

	public @ResponseBody
	FileBlob downFile() throws FileNotFoundException {
		FileBlob fb = new FileBlob ("pinpoint-agent-1.8.1-SNAPSHOT.zip",
				new java.io.FileInputStream(new File("D:/environments/blackcat/pinpoint-agent-1.8.1-SNAPSHOT.zip")));//下载文件流
		return fb;
	}

	public @ResponseBody
	FileBlob collectrules() throws FileNotFoundException {
		FileBlob fb = new FileBlob ("可视化运维数据采集规范.docx",
				new java.io.FileInputStream(new File("D:/environments/blackcat/可视化运维数据采集规范.docx")));//下载文件流
		return fb;
	}
	
	public static void main(String[] args) throws SQLException {
//		String dispoString = "attachment; name=\"filedata\"; filename=\"TempPlanDiagram.png\"";
//		 int iFindStart = dispoString.indexOf(" filename=\"") + 11;
//         int iFindEnd = dispoString.indexOf("\"", iFindStart);
//         String sFileName = dispoString.substring(iFindStart, iFindEnd);
//         iFindStart = dispoString.indexOf(" name=\"") + 7;
//         iFindEnd = dispoString.indexOf("\"", iFindStart);
//         String sFieldName = dispoString.substring(iFindStart, iFindEnd);
		List<Map> datas = SQLExecutor.queryList(Map.class,"select * from user");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//加载配置文件，启动负载均衡器
		HttpRequestProxy.startHttpPools("application.properties");
	}
}
