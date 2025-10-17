<?php

class Comentario
{
    public $id;
    public $id_projeto;
    public $id_usuario;
    public $texto;
    public $data_hora;
    private $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function addProjeto(): array
    {
        try {
            $sql = "CALL CREATE_COMENTARIO_PROJETO(:id_usuario, :id_projeto, :texto);";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_projeto", $this->id_projeto);
            $stmt->bindParam(":id_usuario", $this->id_usuario);
            $stmt->bindParam(":texto", $this->texto);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Comentário cadastrado ao projeto com sucesso!',
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
            'message' => 'Erro desconhecido ao adicionar comentário ao projeto.',
            'data' => []
        ];
    }

    public function readByProjeto() {
        try {
            $sql = "CALL READ_ALL_COMENTARIOS_BY_PROJETO(:id_projeto);";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_projeto", $this->id_projeto);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Comentários encontrados pelo projeto com sucesso!',
                    'data' => $stmt->fetchAll(PDO::FETCH_OBJ)
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
            'message' => 'Erro desconhecido ao buscar comentários pelo projeto.',
            'data' => []
        ];
    }
}