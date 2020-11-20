<?php
    $hostname='localhost';
    $database='bd_prueba';
    $username='root';
    $password='';


    $conexion = mysqli_connect($hostname,$username,$password,$database);

    $Nombre=$_POST['Nombre'];
    $Apellido=$_POST['Apellido'];
    $Edad=$_POST['Edad'];
    $Correo=$_POST['Correo'];
    $Documento=$_POST['Documento'];

    $sql = "UPDATE persona SET Nombre='$Nombre', Apellido='$Apellido', Correo='$Correo', Edad='$Edad' WHERE Documento='$Documento' ";

    $result = mysqli_query($conexion,$sql);

    if($result){
        echo "Data Updated";
    }
    else{
        echo "Failed";
    }
         mysqli_close($connection);
?>