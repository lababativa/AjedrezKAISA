<?php
include 'conexion.php';
$Nombre=$_POST['Nombre'];
$Apellido=$_POST['Apellido'];
$Edad=$_POST['Edad'];
$Correo=$_POST['Correo'];
$Contrasena=$_POST['Contrasena'];
$Documento=$_POST['Documento'];
//RECIBO 


//$Nombre="Ivan";
//$Apellido="Yesid";
//$Edad="2";
//$Correo="iyy@gmail.com";
//$Contrasena="12345";
//$Documento="1192923921";
//validamos que el correo no exista


$sql = "Select * from persona WHERE Correo ='$Correo'";
$resultado = $conexion-> query($sql);


$num = $resultado->num_rows;

if($num > 0){
	//agregamos valores al array
	echo "Correo Existente";
}else{
	//no existen registros
	$consulta="insert into persona (Nombre, Apellido, Edad, Correo, Contrasena,Documento) values('".$Nombre."','".$Apellido."','".$Edad."','".$Correo."','".$Contrasena."','".$Documento."')"; 
		mysqli_query($conexion,$consulta) or die (mysqli_error()); 
		mysqli_close($conexion);	
}


?>




