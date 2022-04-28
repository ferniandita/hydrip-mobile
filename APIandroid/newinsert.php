<?php
include 'koneksi.php';
$query1 = "SELECT * FROM tanaman";
$exe1 = mysqli_query($koneksi,$query1);
while($row = mysqli_fetch_array($exe1))
{
	$temp1[] = $row['s1'];
	$temp2[] = $row['s2'];
	$hum1[] = $row['h1'];
	$hum2[] = $row['h2'];
}

$query2 = "SELECT * FROM luar";
$exe2 = mysqli_query($koneksi,$query2);
while($row = mysqli_fetch_array($exe2))
{
	$air_temp[] = $row['air_temp'];
	$air_hum[] = $row['air_hum'];
	$light[] = $row['light'];
	$ph[] = $row['ph'];
	$level[] = $row['level'];
}

$moist11 = number_format((($hum1[0]+$hum2[0]+$hum1[1]+$hum2[1]+$hum1[2]+$hum2[2])/6),1);
$moist12 = number_format((($hum1[3]+$hum2[3]+$hum1[4]+$hum2[4]+$hum1[5]+$hum2[5])/6),1);
$moist13 = number_format((($hum1[6]+$hum2[6]+$hum1[7]+$hum2[7]+$hum1[8]+$hum2[8])/6),1);
$moist14 = number_format((($hum1[9]+$hum2[9]+$hum1[10]+$hum2[10]+$hum1[11]+$hum2[11])/6),1);

$moist21 = number_format((($hum1[12]+$hum2[12]+$hum1[13]+$hum2[13]+$hum1[14]+$hum2[14])/6),1);
$moist22 = number_format((($hum1[15]+$hum2[15]+$hum1[16]+$hum2[16]+$hum1[17]+$hum2[17])/6),1);
$moist23 = number_format((($hum1[18]+$hum2[18]+$hum1[19]+$hum2[19]+$hum1[20]+$hum2[20])/6),1);
$moist24 = number_format((($hum1[21]+$hum2[21]+$hum1[22]+$hum2[22]+$hum1[23]+$hum2[23])/6),1);

$moist31 = number_format((($hum1[24]+$hum2[24]+$hum1[25]+$hum2[25]+$hum1[26]+$hum2[26])/6),1);
$moist32 = number_format((($hum1[27]+$hum2[27]+$hum1[28]+$hum2[28]+$hum1[29]+$hum2[29])/6),1);
$moist33 = number_format((($hum1[30]+$hum2[30]+$hum1[31]+$hum2[31]+$hum1[32]+$hum2[32])/6),1);
$moist34 = number_format((($hum1[33]+$hum2[33]+$hum1[34]+$hum2[34]+$hum1[35]+$hum2[35])/6),1);

for ($i=0; $i<12; $i++)
{
	$suhu1 = number_format((($temp1[$i]+$temp2[$i])/$i),1);
}
for ($i=12; $i<24; $i++)
{
	$suhu2 = number_format((($temp1[$i]+$temp2[$i])/$i),1);
}
for ($i=24; $i<35; $i++)
{
	$suhu3 = number_format((($temp1[$i]+$temp2[$i])/$i),1);
}

$query = "INSERT INTO monitoring (id_area,time,soil_moisture1,soil_moisture2,soil_moisture3,
		soil_moisture4,soil_temperature,air_humidity,air_temperature,water_level,water_ph,light_intensity)
		VALUES
		(1,now(),'$moist11','$moist12','$moist13','$moist14','$suhu1','$air_hum[0]',
		'$air_temp[0]','$level[0]','$ph[0]','$light[0]'),
		(2,now(),'$moist21','$moist22','$moist23','$moist24','$suhu2','$air_hum[1]',
		'$air_temp[1]','$level[1]','$ph[1]','$light[1]'),
		(3,now(),'$moist31','$moist32','$moist33','$moist34','$suhu3','$air_hum[2]',
		'$air_temp[2]','$level[2]','$ph[2]','$light[2]')";
$exe = mysqli_query($koneksi,$query);
var_dump($exe);
var_dump($query);

?>