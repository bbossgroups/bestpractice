<?php
	/* Note: This thumbnail creation script requires the GD PHP Extension.  
		If GD is not installed correctly PHP does not render this page correctly
		and SWFUpload will get "stuck" never calling uploadSuccess or uploadError
	 */

	// Get the session Id passed from SWFUpload. We have to do this to work-around the Flash Player Cookie Bug
	if (isset($_POST["PHPSESSID"])) {
		session_id($_POST["PHPSESSID"]);
	}

	session_start();
	ini_set("html_errors", "0");

	// Check the upload
	// Check the upload
	if (!isset($_FILES["Filedata"]) || !is_uploaded_file($_FILES["Filedata"]["tmp_name"]) || $_FILES["Filedata"]["error"] != 0) {
		echo "ERROR:invalid upload";
		exit(0);
	}


	if (!isset($_SESSION["file_info"])) {
		$_SESSION["file_info"] = array();
	}
	
	$fileName = md5(rand()*10000000) . ".jpg";
	move_uploaded_file($_FILES["Filedata"]["tmp_name"], "saved/" . $fileName);

	$file_id = md5(rand()*10000000);
	
	$_SESSION["file_info"][$file_id] = $fileName;

	echo "FILEID:" . $file_id;	// Return the file id to the script
	
?>