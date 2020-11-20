<?php
    $hostname='localhost';
    $database='bd_prueba';
    $username='root';
    $password='';


    $conexion = mysqli_connect($hostname,$username,$password,$database);

    $result= array();
    $result['persona'] = array();
    $select= "SELECT *FROM persona";
    $mostrar= mysqli_query($conexion,$select);

    while($row = mysqli_fetch_array($mostrar))
    {
        $index['idPersona'] =$row['0'];
        $index['Nombre'] =$row['1'];
        $index['Apellido'] =$row['2'];
        $index['Edad'] =$row['3'];
        $index['Correo'] =$row['4'];
        $index['Contrasena'] =$row['5'];
        $index['Documento'] =$row['6'];

        array_push($result['persona'],$index);
    }
    $result["success"]="1";
    echo json_encode($result);
    mysqli_close($conexion);
?>