<?php

class Notificacao
{
    public $id;
    public $id_usuario;
    public $assunto;
    public $texto;
    public $data_hora;
    public $status;
    public $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function create()
    {
        try {
            $sql = 'CALL CREATE_NOTIFICACAO(:id_usuario,:assunto,:texto)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $this->id_usuario);
            $stmt->bindParam(":assunto", $this->assunto);
            $stmt->bindParam(":texto", $this->texto);
            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Notificação criada com sucesso!"
                ];
            }
        } catch (Exception $e) {
            http_response_code(500);
            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }

        return [
            "success" => false,
            "message" => "Erro desconhecido!"
        ];
    }

    public function readByUsuario()
    {
        $sql = 'CALL READ_ALL_NOTIFICACOES_BY_USUARIO(:id_usuario)';
        $stmt = $this->con->prepare($sql);
        $stmt->bindParam(":id_usuario", $this->id_usuario);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
}