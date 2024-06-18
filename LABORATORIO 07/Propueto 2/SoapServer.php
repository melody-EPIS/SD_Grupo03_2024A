<?php
include_once 'lib/nusoap.php';
$servicio = new soap_server();

$ns = "urn:peliculaswsdl";
$servicio->configureWSDL("ServicioPeliculas", $ns);
$servicio->schemaTargetNamespace = $ns;

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
    } else {
        return "RESULTADO NO ENCONTRADO";
    }
}

$servicio->register(
    "get_peliculas"
);

$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : file_get_contents('php://input');
$servicio->service($HTTP_RAW_POST_DATA);
?>
