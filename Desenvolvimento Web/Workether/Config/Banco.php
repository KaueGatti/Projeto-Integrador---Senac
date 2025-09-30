<?php

class Banco
{
    private $host = "localhost";
    private $banco = "workether";
    private $usuario = "root";
    private $senha = "tiger";
    public $con;

    public function __construct(){
        $this->con = null;

        try {
            $this->con = new PDO("mysql:host=$this->host;dbname=$this->banco", $this->usuario, $this->senha);
        } catch (PDOException $e) {
            echo "Erro ao conectar: " . $e->getMessage();
        }
    }

    public function conectar(){
        return $this->con;
    }
}
