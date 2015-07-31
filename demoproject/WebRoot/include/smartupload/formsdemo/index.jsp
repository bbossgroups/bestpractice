<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SWFUpload Demos - Classic Form Demo</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../swfupload/swfupload.js"></script>
<script type="text/javascript" src="js/fileprogress.js"></script>
<script type="text/javascript" src="js/handlers.js"></script>
<script type="text/javascript">
		var swfu;

		window.onload = function() {
			var settings = {
				flash_url : "../swfupload/swfupload.swf",
				flash9_url : "../swfupload/swfupload_fp9.swf",
				upload_url: "${pageContext.request.contextPath}/file/uploadFiles.page",
				post_params: {"lastname" : "asdfa"},
				file_size_limit : "10000 MB",
				file_types : "*.*",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: true,

				// Button settings
				button_image_url: "images/TestImageNoText_65x29.png",
				button_width: "65",
				button_height: "29",
				button_placeholder_id: "spanButtonPlaceHolder",
				button_text: '<span class="theFont">Hello</span>',
				button_text_style: ".theFont { font-size: 16; }",
				button_text_left_padding: 12,
				button_text_top_padding: 3,
				
				// The event handler functions are defined in handlers.js
				swfupload_loaded_handler : swfUploadLoaded,
				swfupload_preload_handler : preLoad,
				swfupload_load_failed_handler : loadFailed,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess
			};

			swfu = new SWFUpload(settings);
	     };
	</script>
</head>
<body>
<div id="header">
	<h1 id="logo"><a href="../">SWFUpload</a></h1>
	<div id="version">v2.5.0</div>
</div>

<div id="content">

	<h2>Classic Form Demo</h2>
	<form id="form1" action="thanks.php" enctype="multipart/form-data" method="post">
		<p>This demo shows how SWFUpload might be combined with an HTML form.  It also demonstrates graceful degradation (using the graceful degradation plugin).
			This demo also demonstrates the use of the server_data parameter.  This demo requires Flash Player 9+</p>
		<div class="fieldset">
			<span class="legend">Submit your Application</span>
			<table style="vertical-align:top;">
				<tr>
					<td><label for="lastname">Last Name:</label></td>
					<td><input name="lastname" id="lastname" type="text" style="width: 200px" /></td>
				</tr>
				<tr>
					<td><label for="firstname">First Name:</label></td>
					<td><input name="firstname" id="firstname" type="text" style="width: 200px" /></td>
				</tr>
				<tr>
					<td><label for="education">Education:</label></td>
					<td><textarea name="education"  id="education" cols="0" rows="0" style="width: 400px; height: 100px;"></textarea></td>
				</tr>
				<tr>
					<td><label for="txtFileName">Resume:</label></td>
					<td>
						
		<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend">Upload Queue</span>
		</div>
		<div id="divStatus">0 Files Uploaded</div>
		<div id="divMovieContainer">
			<span id="spanButtonPlaceHolder"></span>
			<input type="button" value="Start Upload" onclick="swfu.startUpload();" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
		</div>
					</td>
				</tr>
				<tr>
					<td><label for="references">References:</label></td>
					<td><textarea name="references" id="references" cols="0" rows="0" style="width: 400px; height: 100px;"></textarea></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Submit Application" id="btnSubmit" />
		</div>
	</form>
</div>
</body>
</html>
