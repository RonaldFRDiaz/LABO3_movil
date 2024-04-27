package com.camrrseis.labo3

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.camrrseis.labo3.data.SimulationDataBase
import com.camrrseis.labo3.ui.theme.Labo3Theme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.lifecycleScope

import com.camrrseis.labo3.data.Libro
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val libros = remember { mutableStateListOf<Libro>() }

            val coroutineScope = rememberCoroutineScope()

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                val lifeCycleScope = LocalLifecycleOwner.current.lifecycleScope
                Button(onClick = {
                    lifeCycleScope.launch {
                        coroutineScope.launch {
                            val newData = SimulationDataBase()
                            libros.addAll(newData)
                            SimulationDataBase().forEach {
                                delay(3000)
                            }
                        }
                    }
                }) {
                    Text("Cargar datos")
                }


                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(libros) { libro ->
                        LibroCard(libro)
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }
            }
        }
    }








    @Composable
    fun LibroCard(libro: Libro) {
        Card(
            modifier = Modifier.fillMaxWidth(),

        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Nombre del libro: ${libro.titulo}")
                Text(text = "Editor: ${libro.autor}")
            }
        }
    }
}

