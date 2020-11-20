<?php
include 'conexion.php';

//RECIBO 
$Correo=$_GET['Correo'];
//$Correo="ivan@gmail.com";
$sql = "Select * from persona WHERE Correo ='$Correo'";
$resultado = $conexion-> query($sql);
//recorrer todos los datos de la consulta


while ($fila = $resultado ->fetch_array()) {

	$datos[]= array_map('utf8_encode', $fila);
}
//arrglo a formato json
echo json_encode($datos);
$resultado -> close();



?>