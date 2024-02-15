package com.example.listadetarefascompose.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadetarefascompose.ui.theme.LIGHT_BLUE
import com.example.listadetarefascompose.ui.theme.WHITE

// Definição do composable Botao, que representa um botão personalizado.
@Composable
fun Botao(
    onCLick: () -> Unit, // Parâmetro da função: ação a ser executada quando o botão é clicado.
    modifier: Modifier,  // Parâmetro da função: propriedades de layout e estilo do botão.
    texto: String        // Parâmetro da função: texto exibido no botão.
) {

    // Chama o composable Button do Jetpack Compose, passando os parâmetros necessários.
    Button(
        onCLick, // Ação a ser executada quando o botão é clicado.
        modifier, // Propriedades de layout e estilo do botão.
        colors = ButtonDefaults.buttonColors(
            containerColor = LIGHT_BLUE, // Cor de fundo do botão definida como LIGHT_BLUE.
            contentColor = WHITE         // Cor do texto do botão definida como WHITE.
        )
    ) {
        // Bloco de conteúdo do botão, que contém o composable Text para exibir o texto do botão.
        Text(
            text = texto,                  // Texto do botão.
            fontWeight = FontWeight.Bold,  // Peso da fonte definido como negrito.
            fontSize = 18.sp               // Tamanho da fonte definido como 18 sp.
        )
    }
}


@Preview
@Composable
fun BotaoPreview() {
    Botao(onCLick = { }, modifier =Modifier.padding(10.dp) , texto ="Teste")
}