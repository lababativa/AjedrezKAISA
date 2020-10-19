<?php 
$hostname='localhost';
$database='bd_prueba';
$username='root'; 
$password='';


$conexion = new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno)
{
	echo "Tenemos problemas con el servidor";
}
?>

<?php

