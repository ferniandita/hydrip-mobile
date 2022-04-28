<?php
include 'koneksi.php';
$array_control=array();
$query = "SELECT * FROM status";
$exe = mysqli_query($koneksi, $query);
while($data = mysqli_fetch_assoc($exe))
{
	$id2 	= $data['id'];
	$st2 	= $data['st'];

	$data_control = [
		'id2' => $id2,
		'st2' => $st2
	];
	array_push($array_control, $data_control);
}
if($exe){
	$response['error'] = FALSE;
	$response['data_control'] = $array_control;
	echo json_encode($response);
}
?>