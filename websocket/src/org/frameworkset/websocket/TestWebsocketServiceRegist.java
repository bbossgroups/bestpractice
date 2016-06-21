package org.frameworkset.websocket;

import org.frameworkset.schedule.ThreadPoolTaskScheduler;
import org.frameworkset.web.servlet.handler.HandlerMappingsTable;
import org.frameworkset.web.socket.config.ServletWebSocketHandlerRegistry;
/**
 * 16:42:08 ERROR Error during ServletContainerInitializer processing
javax.servlet.ServletException: java.lang.InstantiationException: org.glassfish.tyrus.server.TyrusServerConfiguration
	at org.apache.tomcat.websocket.server.WsSci.onStartup(WsSci.java:88) ~[tomcat-embed-websocket-8.0.23.jar:8.0.23]
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5156) ~[tomcat-embed-core-8.0.23.jar:8.0.23]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150) [tomcat-embed-core-8.0.23.jar:8.0.23]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1409) [tomcat-embed-core-8.0.23.jar:8.0.23]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1399) [tomcat-embed-core-8.0.23.jar:8.0.23]
	at java.util.concurrent.FutureTask.run(FutureTask.java:262) [na:1.7.0_55]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145) [na:1.7.0_55]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615) [na:1.7.0_55]
	at java.lang.Thread.run(Thread.java:745) [na:1.7.0_55]
Caused by: java.lang.InstantiationException: org.glassfish.tyrus.server.TyrusServerConfiguration
	at java.lang.Class.newInstance(Class.java:359) ~[na:1.7.0_55]
	at org.apache.tomcat.websocket.server.WsSci.onStartup(WsSci.java:74) ~[tomcat-embed-websocket-8.0.23.jar:8.0.23]
	... 8 common frames omitted
 * @author biaoping.yin
 *
 */
public class TestWebsocketServiceRegist {
	public void webSocketHandlerMapping() {
		ServletWebSocketHandlerRegistry registry = new ServletWebSocketHandlerRegistry(defaultSockJsTaskScheduler());
//		registerWebSocketHandlers(registry);
		HandlerMappingsTable hm = null;
		registry.registHandlerMapping(hm);
	 
//		hm.setOrder(1);
//		return hm;
		 
	}
	
	public ThreadPoolTaskScheduler defaultSockJsTaskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("SockJS-");
		scheduler.setPoolSize(Runtime.getRuntime().availableProcessors());
		scheduler.setRemoveOnCancelPolicy(true);
		return scheduler;
	}

}
