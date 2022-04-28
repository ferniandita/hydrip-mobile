<?php
include 'koneksi.php';
$id_area = $_POST['id_area'];
$auto = $_POST['auto'];
$manual1 = $_POST['manual1'];
$manual2 = $_POST['manual2'];
$manual3 = $_POST['manual3'];
$manual4 = $_POST['manual4'];
$idmanual = $_POST['idmanual'];
$statusManual = $_POST['statusManual'];
if (isset($_POST['auto'])) {
	$query="UPDATE control set auto='$auto', manual1='$manual1', manual2='$manual2', manual3='$manual3', manual4='$manual4' WHERE id_area='$id_area'";
} else {
	if ($idmanual==1) {
		$query="UPDATE control set manual1='$statusManual' WHERE id_area='$id_area'";
	}
	if ($idmanual==2) {
		$query="UPDATE control set manual2='$statusManual' WHERE id_area='$id_area'";
	}
	if ($idmanual==3) {
		$query="UPDATE control set manual3='$statusManual' WHERE id_area='$id_area'";
	}
	if ($idmanual==4) {
		$query="UPDATE control set manual4='$statusManual' WHERE id_area='$id_area'";
	}
}
$exe = mysqli_query($koneksi,$query);
?>