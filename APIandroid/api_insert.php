<?php
include 'koneksi.php';
$query2 = "SELECT * FROM (SELECT * FROM monitoring ORDER BY id_monitoring DESC LIMIT 3) t ORDER BY id_area ASC";
	$exe2 = mysqli_query($koneksi,$query2);
	$old_time = array();
	while($row = mysqli_fetch_array($exe2))
	{
		$old_id[] = $row['id_area'];
		$old_time[] = $row['time'];
	}

for ($i=0; $i<3; $i++)
{
	$idarea[] = $_POST['idarea'][$i];
	$time[] = $_POST['time'][$i];
	$moist1[] = $_POST['moist1'][$i];
	$moist2[] = $_POST['moist2'][$i];
	$moist3[] = $_POST['moist3'][$i];
	$moist4[] = $_POST['moist4'][$i];
	$suhu[] = $_POST['suhu'][$i];
	$hum[] = $_POST['hum'][$i];
	$tem[] = $_POST['tem'][$i];
	$level[] = $_POST['level'][$i];
	$ph[] = $_POST['ph'][$i];
	$light[] = $_POST['light'][$i];
	$note[] = $_POST['note'][$i];

	if ($time[$i] != $old_time[$i]) {
		$query = "INSERT INTO monitoring (id_area,time,soil_moisture1,soil_moisture2,soil_moisture3,
		soil_moisture4,soil_temperature,air_humidity,air_temperature,water_level,water_ph,light_intensity,note)
		VALUES
		('$idarea[$i]','$time[$i]','$moist1[$i]','$moist2[$i]','$moist3[$i]','$moist4[$i]','$suhu[$i]','$hum[$i]',
		'$tem[$i]','$level[$i]','$ph[$i]','$light[$i]','$note[$i]')";
		$exe = mysqli_query($koneksi,$query);
		var_dump($exe);
		var_dump($query);
	}
}
?>