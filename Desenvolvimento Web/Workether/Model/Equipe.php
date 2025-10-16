<?php

class Equipe
{
    public $id;
    public $id_chat;
    public $id_projeto;
    public $id_responsavel;
    public $nome;
    public $descricao;
    public $dataCriacao;
    public $dataDissolucao;
    public $status;
    public $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function create()
    {
        try {
            $sql = "CALL CREATE_EQUIPE(:id_projeto, :id_responsavel, :nome, :descricao)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_projeto", $this->id_projeto);
            $stmt->bindParam(":id_responsavel", $this->id_responsavel);
            $stmt->bindParam(":nome", $this->nome);
            $stmt->bindParam(":descricao", $this->descricao);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Equipe criada com sucesso."
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
            "message" => "Erro desconhecido ao criar equipe."
        ];
    }
    public function update()
    {
        try {
            $sql = "CALL UPDATE_EQUIPE(:id_equipe, :id_responsavel, :nome, :descricao, :dataDissolucao, :status)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_equipe", $this->id);
            $stmt->bindParam(":id_responsavel", $this->id_responsavel);
            $stmt->bindParam(":nome", $this->nome);
            $stmt->bindParam(":descricao", $this->descricao);
            $stmt->bindParam(":dataDissolucao", $this->dataDissolucao);
            $stmt->bindParam(":status", $this->status);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Equipe atualizada com sucesso."
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
            "message" => "Erro desconhecido ao atualizar equipe."
        ];
    }

    public function delete() {
        try {
            $sql = "CALL DELETE_EQUIPE(:id_equipe)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_equipe", $this->id);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Equipe deletada com sucesso."
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
            "message" => "Erro desconhecido ao deletar equipe."
        ];
    }
    public function addUsuarioEquipe($id_usuario, $id_equipe)
    {
        try {
            $sql = "CALL CREATE_USUARIO_EQUIPE(:id_usuario, :id_equipe)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);
            $stmt->bindParam(":id_equipe", $id_equipe);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Usuário adicionado à equipe com sucesso."
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
            "message" => "Erro desconhecido ao adicionar usuário à equipe."
        ];
    }
    public function deleteAllUsuariosEquipe($id_equipe)
    {
        try {
            $sql = "CALL DELETE_ALL_USUARIOS_EQUIPE(:id_equipe)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_equipe", $id_equipe);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Todos os usuários da equipe foram removidos com sucesso."
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
            "message" => "Erro desconhecido ao remover usuários da equipe."
        ];
    }
    public function deleteUsuarioEquipe($id_usuario, $id_equipe)
    {
        try {
            $sql = "CALL DELETE_USUARIO_EQUIPE(:id_usuario, :id_equipe)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);
            $stmt->bindParam(":id_equipe", $id_equipe);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Usuário removido da equipe com sucesso."
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
            "message" => "Erro desconhecido ao remover usuário da equipe."
        ];
    }
    public function readAllByProjeto($id_projeto)
    {
        try {
            $sql = "CALL READ_ALL_EQUIPES_BY_PROJETO(:id_projeto)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_projeto", $id_projeto);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Equipes encontradas pelo projeto.",
                    "data" => $stmt->fetchAll(PDO::FETCH_OBJ)
                ];
            }
        } catch (PDOException $e) {
            return [
                "success" => false,
                "message" => $e->getMessage(),
                "data" => []
            ];
        }

        return [
            "success" => false,
            "message" => "Erro desconhecido ao buscar equipes por projeto.",
            "data" => []
        ];
    }
    public function readAllByUsuario($id_usuario)
    {
        try {
            $sql = "CALL READ_ALL_EQUIPES_BY_USUARIO(:id_usuario)";
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(":id_usuario", $id_usuario);

            if ($stmt->execute()) {
                return [
                    "success" => true,
                    "message" => "Equipes encontradas pelo usuário.",
                    "data" => $stmt->fetchAll(PDO::FETCH_OBJ)
                ];
            }
        } catch (PDOException $e) {
            return [
                "success" => false,
                "message" => $e->getMessage(),
                "data" => []
            ];
        }

        return [
            "success" => false,
            "message" => "Erro desconhecido ao buscar equipes por usuário.",
            "data" => []
        ];
    }
}

