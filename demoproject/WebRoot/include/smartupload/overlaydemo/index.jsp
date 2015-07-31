<%@ page language="java" contentType="text/html; charset=utf-8"%><!DOCTYPE html>
<html>
<head>
<title>SWFUpload Demos - Overlay Demo</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.swfupload {
		position: absolute;
		z-index: 1;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/include/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/include/js/json.js"></script>

<script type="text/javascript" src="../swfupload/swfupload.js"></script>
<script type="text/javascript" src="../swfupload/swfupload.queue.js"></script>
<script type="text/javascript" src="js/fileprogress.js"></script>
<script type="text/javascript" src="js/handlers.js"></script>
<script type="text/javascript">
var swfu;

SWFUpload.onload = function () {
	var settings = {
		flash_url : "../swfupload/swfupload.swf",
		flash9_url : "../swfupload/swfupload_fp9.swf",
		upload_url: "${pageContext.request.contextPath}/file/uploadFiles.page",
		file_size_limit : "10000 MB",
		post_params: formToJson("#form1"),
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : 100,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button Settings
		button_placeholder_id : "spanButtonPlaceholder",
		button_width: 61,
		button_height: 22,
		button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
		button_cursor: SWFUpload.CURSOR.HAND,

		// The event handler functions are defined in handlers.js
		swfupload_preload_handler : swfUploadPreLoad,
		swfupload_load_failed_handler : swfUploadLoadFailed,
		swfupload_loaded_handler : swfUploadLoaded,
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : function(){},//fileDialogComplete
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete	// Queue plugin event
		
	};

	swfu = new SWFUpload(settings);
}

</script>
</head>
<body>
<div id="header">
	<h1 id="logo"><a href="../">SWFUpload</a></h1>
	<div id="version">v2.5.0</div>
</div>

<div id="content">

	<h2>Overlay Demo</h2>
	<form id="form1" action="index.php" method="post" enctype="multipart/form-data">
		<p> This page demonstrates placing transparent button over an existing button using a little bit of simple CSS: </p>
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
					<td><label for="txtFileName">简历:</label></td>
					<td>
		<div id="divSWFUploadUI">
			<div class="fieldset flash" id="fsUploadProgress">
			
			</div>
			<p id="divStatus">0 Files Uploaded</p>
			<p>
				<span id="spanButtonPlaceholder"></span>
				<input id="btnUpload" type="button" value="Select Files" style="width: 61px; height: 22px; font-size: 8pt;" />
				<input id="btnCancel" type="button" value="Cancel All Uploads" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
				<input type="button" value="Start Upload" onclick="document.getElementById('btnCancel').disabled = false;swfu.startUpload();" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
			</p>
			<br style="clear: both;" />
		</div>
		</td>
				</tr>
				<tr>
					<td><label for="references">References:</label></td>
					<td><textarea name="references" id="references" cols="0" rows="0" style="width: 400px; height: 100px;"></textarea></td>
				</tr>
			</table>
		<noscript style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px;">
			We're sorry.  SWFUpload could not load.  You must have JavaScript enabled to enjoy SWFUpload.
		</noscript>
		<div id="divLoadingContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
			SWFUpload is loading. Please wait a moment...
		</div>
		<div id="divLongLoading" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
			SWFUpload is taking a long time to load or the load has failed.  Please make sure that the Flash Plugin is enabled and that a working version of the Adobe Flash Player is installed.
		</div>
		<div id="divAlternateContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
			We're sorry.  SWFUpload could not load.  You may need to install or upgrade Flash Player.
			Visit the <a href="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash">Adobe website</a> to get the Flash Player.
		</div>
	</form>
</div>
</body>
</html>
