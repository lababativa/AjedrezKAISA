<?php
include 'conexion.php';
$PrimerNombre=$_POST['PrimerNombre'];
$SegundoNombre=$_POST['SegundoNombre'];
$Edad=$_POST['Edad'];
$Correo=$_POST['Correo'];
$Contrasena=$_POST['Contrasena'];
//RECIBO 


//$PrimerNombre="Ivan";
//$SegundoNombre="Yesid";
//$Edad="2";
//$Correo="aa@gmail.com";
//$Contrasena="12345";
//validamos que el correo no exista


$sql = "Select * from persona WHERE Correo ='$Correo'";
$resultado = $conexion-> query($sql);


$num = $resultado->num_rows;

if($num > 0){
	//agregamos valores al array
	echo "Correo Existente";
}else{
	//no existen registros
	$consulta="insert into persona (PrimerNombre, SegundoNombre, Edad, Correo, Contrasena) values('".$PrimerNombre."','".$SegundoNombre."','".$Edad."','".$Correo."','".$Contrasena."')"; 
		mysqli_query($conexion,$consulta) or die (mysqli_error()); 
		mysqli_close($conexion);	
}


?>


