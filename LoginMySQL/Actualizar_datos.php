<?php

$hostname='localhost';
$database='bd_prueba';
$username='root'; 
$password='';

if(isset($_POST['Nombre']) && isset($_POST['Apellido']) && isset($_POST['Edad']) && isset($_POST['Correo']) && isset($_POST['Documento'])){

    $Nombre=$_POST['Nombre'];
    $Apellido=$_POST['Apellido'];
    $Edad=$_POST['Edad'];
    $Correo=$_POST['Correo'];
    $Documento=$_POST['Documento'];
    $conexion = new mysqli($hostname,$username,$password,$database);
    $sql = "UPDATE persona SET Nombre = '$Nombre', Apellido = '$Apellido', Correo = '$Correo', Edad = '$Edad' WHERE Documento = '$Documento' ";

    if(mysqli_query($conexion,$sql)){
        $result["success"]="1";
        $result["message"]="success";

        echo json_encode($result);
        mysqli_close($conexion);
    }

}else{

    $result["success"]="0";
    $result["message"]="Error"
    echo json_encode($result);
}
?>