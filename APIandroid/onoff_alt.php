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
// if ($id == 1) {
// 	$query = "UPDATE control SET manual1='$st' WHERE id_area=1";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 2) {
// 	$query = "UPDATE control SET manual2='$st' WHERE id_area=1";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 3) {
// 	$query = "UPDATE control SET manual3='$st' WHERE id_area=1";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 4) {
// 	$query = "UPDATE control SET manual4='$st' WHERE id_area=1";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 5) {
// 	$query = "UPDATE control SET manual1='$st' WHERE id_area=2";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 6) {
// 	$query = "UPDATE control SET manual2='$st' WHERE id_area=2";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 7) {
// 	$query = "UPDATE control SET manual3='$st' WHERE id_area=2";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 8) {
// 	$query = "UPDATE control SET manual4='$st' WHERE id_area=2";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 9) {
// 	$query = "UPDATE control SET manual1='$st' WHERE id_area=3";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 10) {
// 	$query = "UPDATE control SET manual2='$st' WHERE id_area=3";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 11) {
// 	$query = "UPDATE control SET manual3='$st' WHERE id_area=3";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
// if ($id == 12) {
// 	$query = "UPDATE control SET manual4='$st' WHERE id_area=3";
// 	$exe2 = mysqli_query($koneksi, $query);
// }
?>