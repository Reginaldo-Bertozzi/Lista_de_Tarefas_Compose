package com.example.listadetarefascompose.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.listadetarefascompose.ui.theme.BLACK
import com.example.listadetarefascompose.ui.theme.LIGHT_BLUE
import com.example.listadetarefascompose.ui.theme.ShapeEditText
import com.example.listadetarefascompose.ui.theme.WHITE

// Definição do composable CaixaDeTexto, que representa uma caixa de texto personalizada.
@Composable
fun CaixaDeTexto(
    value: String,                // Parâmetro da função: valor atual da caixa de texto.
    onValueChange: (String) -> Unit,  // Parâmetro da função: ação a ser executada quando o valor da caixa de texto muda.
    modifier: Modifier,           // Parâmetro da função: propriedades de layout e estilo da caixa de texto.
    label: String,                // Parâmetro da função: rótulo da caixa de texto.
    maxLines: Int,                // Parâmetro da função: número máximo de linhas da caixa de texto.
    keyBoardType: KeyboardType    // Parâmetro da função: tipo de teclado da caixa de texto.
) {

    // Chama o composable OutlinedTextField do Jetpack Compose, passando os parâmetros necessários.
    OutlinedTextField(
        value = value,  // Valor atual da caixa de texto.
        onValueChange = onValueChange,  // Ação a ser executada quando o valor da caixa de texto muda.
        modifier,       // Propriedades de layout e estilo da caixa de texto.
        label = {
            Text(text = label)  // Rótulo da caixa de texto exibido acima da caixa.
        },
        maxLines = maxLines,  // Número máximo de linhas da caixa de texto.
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = BLACK,            // Cor do texto da caixa de texto.
            focusedBorderColor = LIGHT_BLUE,  // Cor da borda quando a caixa de texto está em foco.
            focusedLabelColor = LIGHT_BLUE,   // Cor do rótulo quando a caixa de texto está em foco.
            backgroundColor = WHITE,          // Cor de fundo da caixa de texto.
            cursorColor = LIGHT_BLUE          // Cor do cursor dentro da caixa de texto.
        ),
        shape = ShapeEditText.small,        // Formato da caixa de texto.
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType    // Opções do teclado, como tipo de teclado.
        )
    )
}


@Preview
@Composable
fun CaixaDeTextoPreview() {
    CaixaDeTexto(
        value = "Reginaldo",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Descrição",
        maxLines = 2,
        keyBoardType = KeyboardType.Text
    )
}