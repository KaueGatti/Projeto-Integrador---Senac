<?php

class Conversa
{
    public $id;
    public $id_usuarioA;
    public $id_usuarioB;

    private $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function create(): array
    {
        try {

            $sql = "CALL CREATE_CONVERSA(:id_usuarioA, :id_usuarioB)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuarioA", $this->id_usuarioA);
            $stmt->bindParam(":id_usuarioB", $this->id_usuarioB);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Conversa cadastrada com sucesso!'
                ];
            }

        } catch (PDOException $e) {
            http_response_code(500);
            return [
                'success' => false,
                'message' => $e->getMessage()
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao criar conversa'
        ];
    }

    public function readByUsuario() {
        try {

            $sql = "CALL READ_ALL_CONVERSAS_BY_USUARIO(:id_usuario)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $this->id_usuarioA);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Conversas retornadas com sucesso!',
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
            'message' => 'Erro desconhecido ao buscar conversas pelo usuário',
            'data' => []
        ];
    }
}