<%@page import="java.text.DecimalFormat"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="test.*,java.util.*"%>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg"%>

<%
	//构建TestBean对象
	TestBean bean = new TestBean();
	bean.setId("uuid");
	bean.setName("多多");
	bean.setSellMonery(10000000);
	bean.setSelldoubleMonery(10000000.334d);//只有double类型的数字小数位，###,###.##才能正确输出后面的小数
	TestBean ibean = new TestBean();
	ibean.setId("uuidinner");
	ibean.setName("多多uuidinner");
	ibean.setSellMonery(10000000);
	bean.setInner(ibean);
	request.setAttribute("testbean",bean);
	
 
%>
<!-- 
	验证数字格式化测试用例
-->
<html>
<head>
<title>验证数字格式化测试用例</title>
</head>
<body>
	<table>
	    
		
		<pg:beaninfo actual="${testbean }">
		<tr class="cms_data_tr">
				<td>
					testbean:
				</td> 
				<td>
					sellfloatMonery:<pg:cell colName="sellfloatMonery" numerformat="###,###.###"/>
				</td>
				<td>
					sellMonery:<pg:cell colName="sellMonery" numerformat="###,##"/>
				</td>
				<td>
					id:<pg:cell colName="id" />
				</td> 
				<td>
					name:<pg:cell colName="name" />
				</td> 
				<td>
					innerid:<pg:cell colName="inner" property="id" />
				</td> 
				<td>
					innername:<pg:cell colName="inner"  property="name" />
				</td> 
			</tr>
			</pg:beaninfo>
		
	</table>
	
	 
	
	
</body>
</html>
