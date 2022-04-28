<?php
include 'koneksi.php';
$array_control=array();
$query = "SELECT * FROM control";
$exe = mysqli_query($koneksi,$query);
while($row = mysqli_fetch_array($exe)){
	$id_area = $row['id_area'];
	$auto 	= $row['auto'];
	$manual1 = $row['manual1'];
	$manual2 = $row['manual2'];
	$manual3 = $row['manual3'];
	$manual4 = $row['manual4'];
	$data_control=[
		'id_area'=>$id_area,
		'auto'=>$auto,
		'manual1'=>$manual1,
		'manual2'=>$manual2,
		'manual3'=>$manual3,
		'manual4'=>$manual4
	];
	array_push($array_control, $data_control);
}
if($exe){
	$response['error'] = FALSE;
	$response['data_control'] = $array_control;
	echo json_encode($response);
}
?>