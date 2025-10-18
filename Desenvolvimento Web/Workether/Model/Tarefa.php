<?php

class Tarefa
{
    public $id;
    public $id_projeto;
    public $id_equipe;
    public $id_responsavel;
    public $nome;
    public $descricao;
    public $dataCriacao;
    public $dataInicialConclusao;
    public $dataAtualConclusao;
    public $dataConclusao;
    public $status;

    public $con;

    public function __construct($con)
    {
        $this->con = $con;
    }

    public function readAllByUser()
    {
        try {
            $sql = 'CALL READ_ALL_TAREFAS_BY_USUARIO(:id_usuario)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_usuario', $this->id_usuario);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Tarefas retornadas com sucesso!',
                    'data' => $stmt->fetchAll(\PDO::FETCH_OBJ)
                ];
            }
        } catch (PDOException $e) {
            return [
                'success' => false,
                'message' => $e->getMessage(),
                'data' => []
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido!',
            'data' => []
        ];
    }

    public function create()
    {
        try {
            $sql = 'CALL CREATE_TAREFA(:id_projeto, :id_equipe, :id_responsavel, :nome, :descricao, :dataInicialConclusao)';
            $stmt = $this->con->prepare($sql);
            $stmt->bindParam(':id_projeto', $this->id_projeto);

            if ($this->dataConclusao != 0) {
                $stmt->bindParam(':id_equipe', $this->id_equipe);
            } else {
                $stmt->bindValue(":id_equipe", null, PDO::PARAM_NULL);
            }

            $stmt->bindParam(':id_responsavel', $this->id_responsavel);
            $stmt->bindParam(':nome', $this->nome);
            $stmt->bindParam(':descricao', $this->descricao);
            $stmt->bindParam(':dataInicialConclusao', $this->dataInicialConclusao);

            if ($stmt->execute()) {
                return [
                    'success' => true,
                    'message' => 'Tarefa criada com sucesso!'
                ];
            }
        } catch (PDOException $e) {
            return [
                'success' => false,
                'message' => $e->getMessage(),
            ];
        }

        return [
            'success' => false,
            'message' => 'Erro desconhecido ao criar tarefa!'
        ];
    }
}