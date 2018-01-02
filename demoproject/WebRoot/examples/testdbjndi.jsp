<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.frameworkset.common.poolman.SQLExecutor" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg"%>
<%
	List<String> results = SQLExecutor.queryListWithDBName(String.class,"datareuse","select user_name from td_sm_user");
	for(int i = 0; i < results.size(); i ++){
		out.print(results.get(i));
		out.print("<br/>");
	}
%>
<html>
<head>
	<title>姓名查询</title>

	<script type="text/javascript">

	</script>
</head>

<body>
<table>
	<tr>
		<td>查询登录名：<input type="text" name="loginName3" id="loginName3"/>
		</td>

		<td><input type="button" value="查询" onclick="doquery()"/>
		</td>
	</tr>
	<tr>
		<td>查询结果：
		</td>
		<td id="queryresult"></td>
	</tr>
</table>
</body>
</html>
