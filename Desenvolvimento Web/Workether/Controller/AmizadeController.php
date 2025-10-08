<?php

require_once __DIR__ . "/../Config/Banco.php";
require_once __DIR__ . "/../Model/Amizade.php";

class AmizadeController
{

    public $amizade;

    public function __construct() {
        $db = new Banco();
        $con = $db->conectar();
        $this->amizade = new Amizade($con);
    }

    public function readAllAmizadesByUsuario($id_usuario) {
        return $this->amizade->readAllUsuario($id_usuario);
    }
}