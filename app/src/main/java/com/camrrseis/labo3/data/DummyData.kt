package com.camrrseis.labo3.data

import kotlinx.coroutines.delay

suspend fun SimulationDataBase(): MutableList<Libro> {
    delay(3000)
    return mutableListOf(
        Libro("El nombre del viento","Patrick Rothfuss"),
        Libro("El placer de leer" , "Wendy Lesser"),
        Libro("Harry Potter","J.K. Rowling"),
        Libro("la noche del mañana","Patrick Rothfuss"),
        Libro("Siempre contigo","Harold Bloom"),
        Libro("una noche bajo la estrella","Jorge Luis Borges"),
        Libro("nunca fallo","Patrick Rothfuss"),
        Libro("buscando a las madres","Patrick Rothfuss"),
        Libro("lo bueno de la materia","Patrick Rothfuss"),
        Libro("siempre a tu lado","Patrick Rothfuss"),
        Libro("siempre vuelve","Patrick Rothfuss"),
        Libro("ahorro de problema","Patrick Rothfuss"),
        Libro("holaaa","Patrick Rothfuss"),
        Libro("siempre a tu lado","Patrick Rothfuss"),
    )
}
