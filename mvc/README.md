# 打war包：

gradle war

#启动应用

gradle tomcatStart

#参数绑定demo访问地址

http://localhost:8080/mvc/examples/index.page
# 缓存示例访问地址
##etag 
http://localhost:8080/mvc/caches/etgcache.page
##Last-Modified
http://localhost8080/mvc/caches/cache.page?millis=1473172518546

#响应带日期类型的json报文

http://localhost:8080/mvc/examples/getJsonDateBean.page
json报文处理日期默认转换为long型返回客户端，如果需要格式化日期，则需要在bboss-mvc.xml文件中对jackson插件进行设置：
<property class="org.frameworkset.http.converter.json.MappingJacksonHttpMessageConverter">
     				<property name="objectMapper" class="com.fasterxml.jackson.databind.ObjectMapper">
     					<property name="dateFormat" class="java.text.SimpleDateFormat">
     						<construction>  
				            <property value="yyyy-MM-dd HH:mm:ss"/>
				        </construction>
     					</property>
     				</property>
     		</property>
