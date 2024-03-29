package com.example.listadetarefascompose.repositorio

import com.example.listadetarefascompose.datasource.DataSource

class TarefasRepositorio() {

    private val dataSource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }
}