<?php
	include 'koneksi.php';	
	$id   = $_POST['id'];
	$st   = $_POST['st'];
	$exe = mysqli_query($koneksi,"UPDATE status SET st='$st' WHERE id='$id'"); 

	$data = [
		'id' => $id,
		'st' => $st
	];
	if($exe){
	$response['error'] = FALSE;
	$response['data'] = $data;
	echo json_encode($response);
}

?>