package com.example.estudoconcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.estudoconcurso.ui.screens.AddressForm
import com.example.estudoconcurso.ui.theme.EstudoConcursoTheme2
import com.example.estudoconcurso.ui.viewModels.AddressViewModel
/*import com.google.firebase.Firebase
import com.google.firebase.database.database*/
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstudoConcursoTheme2 {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scope = rememberCoroutineScope()
                    val viewModel = koinViewModel<AddressViewModel>()
                    val uiState by viewModel.uiState.collectAsState()
                    AddressForm(
                        uiState,
                        onSearchAddressClick = { cep ->
                            /*scope.launch {
                                viewModel.findAddress(cep)
                            }*/
                            /*// Write a message to the database
                            val database = Firebase.database
                            val myRef = database.getReference("message")

                            myRef.setValue("Hello, World!")*/
                        }
                    )
                }
            }
        }
    }

}