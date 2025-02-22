package com.example.estudoconcurso.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estudoconcurso.ui.theme.EstudoConcursoTheme2
import com.example.estudoconcurso.ui.transformations.CepVisualTransformation
import com.example.estudoconcurso.ui.uistates.UserFormUiState

@Composable
fun UserForm(
    uiState: UserFormUiState,
    onSearchAddressClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize()) {
        when {
            uiState.isError -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                ) {
                    Text(
                        text = "Falha ao buscar o endereço",
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center),
                        color = Color.White
                    )
                }
            }

            uiState.isLoading -> {
                Box(Modifier.fillMaxWidth()) {
                    /*CircularProgressIndicator(
                        Modifier
                            .padding(8.dp)
                            .align(Alignment.Center)
                    )*/
                }
            }
        }
        Column(
            modifier
                .verticalScroll(rememberScrollState())
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val addressTextFieldModifier = Modifier
                .fillMaxWidth()
            var cep by remember {
                mutableStateOf("")
            }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = cep,
                    onValueChange = {
                        if (it.length < 9) {
                            cep = it
                        }
                    },
                    Modifier.weight(1f),
                    label = {
                        Text(text = "CEP")
                    },
                    visualTransformation = CepVisualTransformation
                )
                IconButton(onClick = { onSearchAddressClick(cep) }) {
                    Icon(
                        Icons.Default.Search,
                        "lupa indicando ação de busca",
                        Modifier.fillMaxHeight()
                    )
                }
            }
            var nome by remember(uiState.nome) {
                mutableStateOf(uiState.nome)
            }
            TextField(
                value = nome,
                onValueChange = {
                    nome = it
                },
                addressTextFieldModifier,
                label = {
                    Text(text = "Nome")
                }
            )
            var idade by remember(uiState.idade) {
                mutableIntStateOf(value = uiState.idade)
            }
            TextField(
                value = idade.toString(),
                onValueChange = {
                    idade = it.toInt()
                },
                addressTextFieldModifier,
                label = {
                    Text(text = "Idade")
                }
            )
        }
    }
}

@Preview
@Composable
fun UserFormPreview() {
    EstudoConcursoTheme2 {
        Surface(color = MaterialTheme.colorScheme.background) {
            UserForm(
                uiState = UserFormUiState(),
                onSearchAddressClick = {}
            )
        }
    }
}