<?php
include 'conexion.php';
$Correo=$_POST['usuario'];
$Contrasena=$_POST['password'];

//$Correo="ivan@gmail.com";
//$Contrasena="2345";


//arrary para guardar informacion
$sentencia=$conexion->prepare("Select * FROM persona WHERE Correo=? AND Contrasena=?");
$sentencia->bind_param('ss', $Correo,$Contrasena);
$sentencia->execute();

$resultado= $sentencia-> get_result();
$data  = array();
$num = $resultado->num_rows;

if($num>0){
	//agregamos valores al array
	echo "Ingresaste Correctamente";
}else{
	//no existen registros
	echo("No puede ingresar");
	
}
$sentencia -> close();

?>

