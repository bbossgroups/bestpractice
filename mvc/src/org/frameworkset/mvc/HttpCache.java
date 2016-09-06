package org.frameworkset.mvc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.frameworkset.http.HttpHeaders;
import org.frameworkset.http.HttpStatus;
import org.frameworkset.http.ResponseEntity;
import org.frameworkset.util.MultiValueMap;
import org.frameworkset.util.annotations.RequestHeader;
import org.frameworkset.util.annotations.RequestParam;

public class HttpCache {

	public HttpCache() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws ParseException
	{
		DateFormat gmtDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		gmtDateFormat.parse("Thu, 1 Jan 1970 08:00:00 GMT");
	}
	
	public ResponseEntity<String> cache(
		      HttpServletRequest request,
		      //为了方便测试，此处传入文档最后修改时间
		      @RequestParam(name="millis") long lastModifiedMillis,
		      //浏览器验证文档内容是否修改时传入的Last-Modified If-Modified-Since
		      @RequestHeader (name = "If-Modified-Since", required = false,dateformat="EEE, d MMM yyyy HH:mm:ss.SSS 'GMT'",locale = "en_US") Date ifModifiedSince) {

		    //当前系统时间
		    long now = System.currentTimeMillis();
		    //文档可以在浏览器端/proxy上缓存多久
		    long maxAge = 20;

		    //判断内容是否修改了，此处使用等值判断
		    if(ifModifiedSince != null && ifModifiedSince.getTime() == lastModifiedMillis) {
		        return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		    }

		    DateFormat gmtDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss.SSS 'GMT'", Locale.US);
		    System.out.println(System.currentTimeMillis());
		    String body = "<a href=''>点击访问当前链接</a>";
		    MultiValueMap<String, String> headers = new HttpHeaders();

		    //文档修改时间
		    headers.add("Last-Modified", gmtDateFormat.format(new Date(lastModifiedMillis)));
		    //当前系统时间
		    headers.add("Date", gmtDateFormat.format(new Date(now)));
		    //过期时间 http 1.0支持
		    headers.add("Expires", gmtDateFormat.format(new Date(now + maxAge)));
		    //文档生存时间 http 1.1支持
		    headers.add("Cache-Control", "max-age=" + maxAge);
		    return new ResponseEntity<String>(body, headers, HttpStatus.OK,"String");
		}

}
