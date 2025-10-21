<?php

class Mensagem
{
    public $id;
    public $id_conversa;
    public $id_usuario;
    public $texto;
    public $data_hora;

    private $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function createToConversa(): array
    {
        try {

            $sql = "CALL CREATE_MENSAGEM_CONVERSA(:id_conversa, :id_usuario, :texto)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_conversa", $this->id_conversa);
            $stmt->bindParam(":id_usuario", $this->id_usuario);
            $stmt->bindParam(":texto", $this->texto);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Mensagem da conversa cadastrada com sucesso!',
                    'data' => $stmt->fetch(PDO::FETCH_OBJ)
                ];
            }

        } catch (PDOException $e) {
            http_response_code(500);
            return [
                'success' => false,
                'message' => $e->getMessage(),
                'data' => []
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao criar mensagem para conversa',
            'data' => []
        ];
    }
}