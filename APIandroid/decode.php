<?php
$url2 = 'http://localhost/hydrip/APIandroid/api_update.php';
$isi2 = file_get_contents($url2);
$decode2 = json_decode($isi2, true);
$data_control = $decode2['data_control'];
var_dump($data_control);
?>