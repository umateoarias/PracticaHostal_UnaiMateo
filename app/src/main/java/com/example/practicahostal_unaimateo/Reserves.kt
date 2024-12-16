package com.example.practicahostal_unaimateo

import java.time.Instant
import java.util.Date

data class Reserva(
    val numReserva: Int,
    val nom : String,
    val cognoms : String,
    val email : String,
    val numTelefon : String,
    val tipusHab : Int,
    val dataInici : Date,
    val dataFinal : Date
)

var reserves = listOf<Reserva>()