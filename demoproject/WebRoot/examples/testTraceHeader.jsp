<%@ page import="org.frameworkset.spi.remote.http.HttpRequestUtil" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String ret = HttpRequestUtil.httpGetforString("http://localhost:8080/demoproject/examples/testTraceHeader.page");
System.out.println(ret);
%>