<?php
include 'koneksi.php';
$id = $_POST['id'];
$s1 = $_POST['s1'];
$s2 = $_POST['s2'];
$h1 = $_POST['h1'];
$h2 = $_POST['h2'];
$v1 = $_POST['v1'];
$s  = $_POST['s'];

if($s==59)
{ 
	if ($id < 37) {
		$query = "SELECT * FROM tanaman WHERE id='$id'";
		$exe = mysqli_query($koneksi,$query);
		while($data = mysqli_fetch_assoc($exe))
		{
			$s1a  = $data['s1alias'];
			$s2a  = $data['s2alias'];
			$h1a  = $data['h1alias'];
			$h2a  = $data['h2alias'];
		}

		mysqli_query($koneksi,"INSERT INTO log_tanaman (id2,ux,time,s1,s2,h1,h2,v1,s1alias,s2alias,h1alias,h2alias) 
			VALUES ('$id','',now(),'$s1','$s2','$h1','$h2','$v1','$s1a','$s2a','$h1a','$h2a')");
		mysqli_query($koneksi,"UPDATE tanaman SET s1='$s1', s2='$s2', h1='$h1', h2='$h2', v1='$v1' WHERE id='$id'");
	} elseif ($id>=37 && $id<=39) {
		$query = "SELECT * FROM luar WHERE id='$id'";
		$exe = mysqli_query($koneksi,$query);
		while($data = mysqli_fetch_assoc($exe))
		{
			$loc_temp  = $data['loc_temp'];
			$loc_hum  = $data['loc_hum'];
			$loc_light  = $data['loc_light'];
			$loc_ph  = $data['loc_ph'];
		}

		mysqli_query($koneksi,"INSERT INTO log_luar (id2,ux,time,air_temp,air_hum,light,ph,level,loc_temp,loc_hum,loc_light,loc_ph) 
			VALUES ('$id','',now(),'$s1','$s2','$h1','$h2','$v1','$loc_temp','$loc_hum','$loc_light','$loc_ph')") or die (mysqli_error($koneksi));
		mysqli_query($koneksi,"UPDATE luar SET air_temp='$s1', air_hum='$s2', light='$h1', ph='$h2', level='$v1' WHERE id='$id'");
	}
}

?>