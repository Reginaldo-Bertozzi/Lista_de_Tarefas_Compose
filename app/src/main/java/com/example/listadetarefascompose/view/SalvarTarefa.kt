package com.example.listadetarefascompose.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listadetarefascompose.componentes.Botao
import com.example.listadetarefascompose.componentes.CaixaDeTexto
import com.example.listadetarefascompose.constantes.Constantes
import com.example.listadetarefascompose.repositorio.TarefasRepositorio
import com.example.listadetarefascompose.ui.theme.Purple40
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_GREEN_DISABLE
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_RED_DISABLE
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_YELLOW_DISABLE
import com.example.listadetarefascompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.example.listadetarefascompose.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// A anotação @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") é usada para suprimir avisos específicos do lint relacionados ao ScaffoldPaddingParameter do Material3.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// Composable que define a tela de "Salvar Tarefa".
@Composable
fun SalvarTarefa(
    navController: NavController  // Parâmetro da função: NavController utilizado para navegação.
) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tarefasRepositorio = TarefasRepositorio()

    // Composable Scaffold é usado para criar uma estrutura básica de layout, que inclui uma barra superior (TopAppBar) e um conteúdo.
    Scaffold(
        topBar = {
            // Barra superior (TopAppBar) que exibe o título da tela.
            TopAppBar(
                backgroundColor = Purple40,  // Cor de fundo da barra superior.
                title = {
                    // Texto exibido como título da barra superior.
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        }
    ) {

        // Declaração de variáveis de estado usando remember para reter o estado entre recomposições.
        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descriçãoTarefa by remember {
            mutableStateOf("")
        }

        var semPrioridadeTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeBaixaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeMédiaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeAltaTarefa by remember {
            mutableStateOf(false)
        }

        // Coluna principal que contém os diferentes componentes da tela, como caixas de texto, botões e radio buttons.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())  // Permite rolar verticalmente dentro da coluna.
        ) {
            // Caixa de texto para o título da tarefa.
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 70.dp, 20.dp, 0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyBoardType = KeyboardType.Text
            )

            // Caixa de texto para a descrição da tarefa.
            CaixaDeTexto(
                value = descriçãoTarefa,
                onValueChange = {
                    descriçãoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição",
                maxLines = 5,
                keyBoardType = KeyboardType.Text
            )

            // Row que contém RadioButtons para escolher o nível de prioridade da tarefa.
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Nível de prioridade")

                // RadioButton para prioridade baixa.
                RadioButton(
                    selected = prioridadeBaixaTarefa, onClick = {
                        prioridadeBaixaTarefa = !prioridadeBaixaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLE,
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED
                    )
                )

                // RadioButton para prioridade média.
                RadioButton(
                    selected = prioridadeMédiaTarefa, onClick = {
                        prioridadeMédiaTarefa = !prioridadeMédiaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLE,
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                    )
                )

                // RadioButton para prioridade alta.
                RadioButton(
                    selected = prioridadeAltaTarefa, onClick = {
                        prioridadeAltaTarefa = !prioridadeAltaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_RED_DISABLE,
                        selectedColor = RADIO_BUTTON_RED_SELECTED
                    )
                )
            }

            // Botão para salvar a tarefa.
            Botao(
                onCLick = {

                    var mensagem = true

                    scope.launch(Dispatchers.IO) {
                        if (tituloTarefa.isEmpty()) {
                            mensagem = false
                        } else if (tituloTarefa.isNotEmpty() && descriçãoTarefa.isNotEmpty() && prioridadeBaixaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_BAIXA
                            )
                            mensagem = true
                        } else if (tituloTarefa.isNotEmpty() && descriçãoTarefa.isNotEmpty() && prioridadeMédiaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_MEDIA
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descriçãoTarefa.isNotEmpty() && prioridadeAltaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_ALTA
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descriçãoTarefa.isNotEmpty() && semPrioridadeTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.SEM_PRIORIDADE
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && prioridadeBaixaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_BAIXA
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && prioridadeMédiaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_MEDIA
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && prioridadeAltaTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.PRIORIDADE_ALTA
                            )
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && semPrioridadeTarefa) {
                            tarefasRepositorio.salvarTarefa(
                                tituloTarefa,
                                descriçãoTarefa,
                                Constantes.SEM_PRIORIDADE
                            )
                            mensagem = true
                        }
                    }
                    scope.launch(Dispatchers.Main) {
                        if (mensagem) {
                            Toast.makeText(
                                context,
                                "Sucesso ao salvar a tarefa",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.popBackStack()
                        } else {
                            Toast.makeText(
                                context,
                                "Título da tarefa é obrigatório",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "Salvar"
            )
        }
    }
}
