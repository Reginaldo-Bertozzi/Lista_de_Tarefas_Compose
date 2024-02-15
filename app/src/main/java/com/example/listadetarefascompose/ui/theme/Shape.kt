package com.example.listadetarefascompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

// Definição de um objeto `Shapes` que contém diferentes formas (RoundedCornerShape) para tamanhos específicos.
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),   // Forma para tamanho pequeno com cantos arredondados de 4 dp.
    medium = RoundedCornerShape(8.dp),  // Forma para tamanho médio com cantos arredondados de 8 dp.
    large = RoundedCornerShape(12.dp), // Forma para tamanho grande com cantos arredondados de 12 dp.
)

// Definição de um objeto `ShapeEditText` que contém diferentes formas (RoundedCornerShape)
// para tamanhos específicos, especialmente para caixas de texto.
val ShapeEditText = Shapes(
    small = RoundedCornerShape(10.dp),  // Forma para caixa de texto pequena com cantos arredondados de 10 dp.
    medium = RoundedCornerShape(20.dp), // Forma para caixa de texto média com cantos arredondados de 20 dp.
    large = RoundedCornerShape(30.dp),  // Forma para caixa de texto grande com cantos arredondados de 30 dp.
)

val ShapeCardPrioridade = Shapes(
    small = RoundedCornerShape(30.dp),  // Forma para caixa de texto pequena com cantos arredondados de 10 dp.
    medium = RoundedCornerShape(50.dp), // Forma para caixa de texto média com cantos arredondados de 20 dp.
    large = RoundedCornerShape(100.dp),  // Forma para caixa de texto grande com cantos arredondados de 30 dp.
)
