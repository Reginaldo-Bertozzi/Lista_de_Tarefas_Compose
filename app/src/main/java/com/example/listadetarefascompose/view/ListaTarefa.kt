package com.example.listadetarefascompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listadetarefascompose.R
import com.example.listadetarefascompose.itemlista.TarefaItem
import com.example.listadetarefascompose.model.Tarefa
import com.example.listadetarefascompose.ui.theme.BLACK
import com.example.listadetarefascompose.ui.theme.Purple40
import com.example.listadetarefascompose.ui.theme.WHITE
import com.google.firebase.Firebase

// A anotação @SuppressLint("UnusedMaterialScaffoldPaddingParameter") é usada para suprimir avisos específicos do lint relacionados ao ScaffoldPaddingParameter do Material3.
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
// Composable que define a tela de "Lista de Tarefas".
@Composable
fun ListaTarefas(
    navController: NavController  // Parâmetro da função: NavController utilizado para navegação.
) {

    Firebase

    // Composable Scaffold é usado para criar uma estrutura básica de layout, que inclui uma barra superior (TopAppBar) e um conteúdo.
    Scaffold(
        topBar = {
            // Barra superior (TopAppBar) que exibe o título da tela.
            TopAppBar(
                backgroundColor = Purple40,  // Cor de fundo da barra superior.
                title = {
                    // Texto exibido como título da barra superior.
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        },
        backgroundColor = BLACK,  // Cor de fundo da tela.
        floatingActionButton = {
            // Botão flutuante para adicionar nova tarefa.
            FloatingActionButton(
                onClick = {
                    navController.navigate("SalvarTarefa")  // Navega para a tela de "Salvar Tarefa" ao ser clicado.
                },
                backgroundColor = Purple40  // Cor de fundo do botão flutuante.
            ) {
                // Ícone dentro do botão flutuante.
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Ícone de salvar tarefa!"
                )
            }
        }
    ) {
        val listaTarefas:MutableList<Tarefa> = mutableListOf(
            Tarefa(
                tarefa = "Jogar futebol",
                descricao = "mlkmsdlkm lkmsdf lkm sdflkm sdlfkm lk",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "Ir ao cinema",
                descricao = "mlkmsdlkm lkmsdf lkm sdflkm sdlfkm lk",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "Estudar para a prova",
                descricao = "mlkmsdlkm lkmsdf lkm sdflkm sdlfkm lk",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "Acabar o projeto",
                descricao = "mlkmsdlkm lkmsdf lkm sdflkm sdlfkm lk",
                prioridade = 3
            )
        )
        
        LazyColumn {
            itemsIndexed(listaTarefas){ position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }
    }
}

