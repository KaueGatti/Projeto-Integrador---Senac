<?php

class Amizade
{
    public $usuarioA;
    public $usuarioB;
    public $con;

    public function __construct($con) {
        $this->con = $con;
    }

    public function readAllUsuario($id_usuario) {
        try {

            $sql = "CALL READ_ALL_AMIZADES_BY_USER(:id_usuario)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);
            $stmt->execute();
            return $stmt->fetchAll(PDO::FETCH_OBJ);

        } catch (PDOException $e) {
            return $e->getMessage();
        }
    }
}