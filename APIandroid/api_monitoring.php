<?php
include 'koneksi.php';

$array = array();
$query = "SELECT * FROM monitoring ORDER BY id_monitoring DESC LIMIT 3";
$exe = mysqli_query($koneksi,$query);
while($row = mysqli_fetch_array($exe))
{
	$id_area = $row['id_area'];
	$date = date('d M Y H:i:s', strtotime($row['time']));
	$moist1 = $row['soil_moisture1'];  
	$moist2 = $row['soil_moisture2'];
	$moist3 = $row['soil_moisture3'];
	$moist4 = $row['soil_moisture4'];
	$suhu = $row['soil_temperature'];
	$hum = $row['air_humidity'];
	$tem = $row['air_temperature'];
	$lvl = $row['water_level'];
	$ph = $row['water_ph'];
	$li = $row['light_intensity'];
	
	$data = [
		'id_area' => $id_area,
		'date' => $date,
		'hum'=> $hum,
		'airtem' => $tem,
		'level' => $lvl,
		'ph' => $ph,
		'light' => $li,
		'moist1' => $moist1,
		'moist2' => $moist2,
		'moist3' => $moist3,
		'moist4' => $moist4,
		'suhu' => $suhu
	];
	array_push($array, $data);
}

if($exe){
	$response['error'] = FALSE;
	$response['data_monitoring'] = $array;
	echo json_encode($response);
}
?>