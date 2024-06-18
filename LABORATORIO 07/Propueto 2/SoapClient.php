<?php

require_once "lib/nusoap.php";
$client = new nusoap_client("http://localhost/NuSoap/SoapServer.php");

if($_POST){
$decada = $_POST['decada'];
$parametros= array('decada'=>$decada);
$respuesta= $client->call("get_peliculas",$parametros);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css"></link>
    <title>SOAP</title>
</head>
<body>
<div class="container">
    <form class="form" action="SoapClient.php" method="post">
        <label class="label" for="decada"> Ingrese el año:</label>
        <input type="text" name="decada" id="decada">
        <input type="submit" value="Buscar">
    </form>
    <div class="respuesta">
        <?php
    global $respuesta;
    print_r($respuesta);
    ?>
    </div>
    
</body>
</html>