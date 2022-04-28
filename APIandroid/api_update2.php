<?php
include 'koneksi.php';
$array=array();
$query = "SELECT * FROM control";
$exe = mysqli_query($koneksi,$query);
while($row = mysqli_fetch_array($exe)){
	$id 	= $row['id_area'];
	$C 	= $row['auto'];
	$M1	= $row['manual1'];
	$M2	= $row['manual2'];
	$M3	= $row['manual3'];
	$M4	= $row['manual4'];

	$data=[
		'idarea'=>$id,
		'C'=>$C,
		'M1'=>$M1,
		'M2'=>$M2,
		'M3'=>$M3,
		'M4'=>$M4
	];
	array_push($array, $data);
}
if($exe){
	$response['error'] = FALSE;
	$response['data'] = $array;
	echo json_encode($response);
}
?>