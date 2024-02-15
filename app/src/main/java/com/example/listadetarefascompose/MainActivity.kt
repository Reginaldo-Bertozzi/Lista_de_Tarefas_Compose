package com.example.listadetarefascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listadetarefascompose.ui.theme.ListaDeTarefasComposeTheme
import com.example.listadetarefascompose.view.ListaTarefas
import com.example.listadetarefascompose.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTarefasComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "ListaTarefas") {
                    composable(
                        route = "ListaTarefas"
                    ){
                        ListaTarefas(navController)
                    }
                    composable(
                        route = "SalvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }
                }
            }
        }
    }
}

