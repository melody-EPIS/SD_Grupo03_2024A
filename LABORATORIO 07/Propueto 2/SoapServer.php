<?php
require_once "lib/nusoap.php";
global $server;
$server = new soap_server();

function get_peliculas($decada) {
    if ($decada == "1930") {
        return join(" , ", array(
            "Lo que el viento se llevó",
            "Vive como quieras",
            "Sucedió una noche"));
    }
    if ($decada == "1990") {
        return join(" , ", array(
            "El joven manos de tijera",
            "Hombres de negro",
            "El show de Truman"));
    }
    if ($decada == "2000") {
        return join(" , ", array(
            "Batman: el caballero de la noche",
            "Donnie Darko",
            "Eterno resplandor de una mente sin recuerdos"));
    }
    if ($decada == "2010") {
        return join(" , ", array(
            "El Origen",
            "Drive",
            "Los vengadores"));
    }
    if ($decada == "2020") {
        return join(" , ", array(
            "Duna",
            "CODA",
            "Tik, Tik, Boom!"));
    } 
    else {
        return join(" ", array("RESULTADO NO ENCONTRADO"));
    } 
}

$server->register("get_peliculas");
$httpPost = file_get_contents( 'php://input' ); 
$server->service($httpPost);
?>