<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="static org.frameworkset.spi.remote.http.HttpRequestProxy.*" %>
<%

/**
 * 简单的测试树
 */
 %>

 <%     

	 String rootPath = org.frameworkset.mvc.FileController.getWorkFoldPath();
%>
<%@ taglib uri="/WEB-INF/treetag.tld" prefix="tree" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
String treetype = request.getParameter("treetype");
String id = treetype+"root";
%>
<html>
	<head>
		<title>简单的测试树</title>
		<style type="text/css">
.a_bg_color{
	color: white;
    cursor:hand;
	background-color: #191970
}
</style>

	</head>
	<body class="contentbodymargin" scroll="no">
		<div id="contentborder">
		    <table >
		    	
		        <tr><td>
		        <!-- 
		        	通过一整套的树标签，生成树
		        	tree 属性指定树的唯一名称
		        	imageFolder 指定树节点的图标目录
		        	collapse 指定树节点是否全部铺开，并且不能折叠，true可以折叠，false全部展开但是不能折叠
		        	includeRootNode 是否包含根节点
		        	href 节点全局url地址
		        	target 节点url弹出窗口
		        	mode 控制树的展示模式，为动静模式
		         -->
		         <tree:tree tree="simple_tree"
		    	           node="simple_tree.node"
		    	           imageFolder="../examples/tree_images"
		    	           collapse="true"
		    			   includeRootNode="true"	
		    			  jquery="true"
		    			   mode="static-dynamic"
		    			   > 
		    		          
		                  
		                   <!-- 指定树的数据加载器和根节点信息
		                   		treetype-数据加载器的实现类，这里是test.tree.TestTree
		                   		scope 数据加载器对象的存储范围，一般是request级别
		                   		
		                   		指定根节点的信息：
		                   		rootid 根节点的id
		                   		rootName 根节点的名称
		                   		
		                   		expandLevel 默认展开多少级
		                   		enablecontextmenu 是否启用右键菜单，true启用，false不启用
		                    -->
		    			   <tree:treedata treetype="org.frameworkset.mvc.FolderTree"
		    	                   scope="request"
		    	                   rootid="<%=rootPath %>"  
		    	                   rootName="资源管理"
		    	                   expandLevel="2"
		    	                   showRootHref="true"
		    	                   needObserver="false"
		    	                   refreshNode="false"
		    	                   enablecontextmenu="false" 
		    	                   />
		
		    	</tree:tree>
		         </td></tr>
		    </table>
		</div>

	</body>
</html>
