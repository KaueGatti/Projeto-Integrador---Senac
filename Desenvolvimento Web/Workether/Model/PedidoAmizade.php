<?php

class PedidoAmizade
{
    public $id;
    public $id_notificacao;
    public $id_solicitante;
    public $id_receptor;
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

            $sql = "CALL CREATE_PEDIDO_AMIZADE(:id_solicitante, :id_receptor)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_solicitante", $this->id_solicitante);
            $stmt->bindParam(":id_receptor", $this->id_receptor);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Pedido de amizade criado com sucesso!'
                ];
            }
        } catch (PDOException $e) {
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

    public function update()
    {
        try {

            $sql = "CALL UPDATE_PEDIDO_AMIZADE(:id, :status)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id", $this->id);
            $stmt->bindParam(":status", $this->status);
            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Pedido de amizade atualizado com sucesso!'
                ];
            }
        } catch (PDOException $e) {
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

    public function readByNotificacao() {
        try {
            $sql = "CALL READ_PEDIDO_AMIZADE_BY_NOTIFICACAO(:id_notificacao)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_notificacao", $this->id_notificacao);
            $stmt->execute();
            return $stmt->fetch(PDO::FETCH_OBJ);

        } catch (PDOException $e) {
            http_response_code(500);
            return [
                "success" => false,
                "message" => $e->getMessage()
            ];
        }
    }
}