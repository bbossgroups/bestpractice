<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<title></title>
	

	<script src="${pageContext.request.contextPath}/include/jquery-1.4.2.min.js"></script>
		<script src='../jquery.MetaData.js' type="text/javascript" language="javascript"></script>
	<script src='../jQuery.MultiFile.min.js' type="text/javascript" language="javascript"></script>
	
</head>

<body>

	<div class="container-fluid">

		<form action="${pageContext.request.contextPath}/file/uploadFiles.page" method="post" enctype="multipart/form-data" >
			<div >
				<div >
					<input type="file" class="multi
  max-3
  accept-gif|jpg|pdf|pptx|exe
  maxsize-1024" />
				</div>
				<div >
					<input type="submit" value="上传"/>
					
				</div>
			</div>
		</form>
		<script>

		</script>
	



	<!--// plugin-specific resources //-->


</body>

</html>
