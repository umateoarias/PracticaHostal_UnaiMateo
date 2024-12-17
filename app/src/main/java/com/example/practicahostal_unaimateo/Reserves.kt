package com.example.practicahostal_unaimateo

import java.time.Instant
import java.util.Calendar
import java.util.Date

data class Reserva(
    val numReserva: Int,
    val nom : String,
    val cognoms : String,
    val email : String,
    val numTelefon : String,
    val tipusHab : Int,
    val dataInici : Date,
    val dataFinal : Date,
    var preu : Double
)

var reserves = listOf<Reserva>()

fun calculatePreu(reserva: Reserva):Double{
    val preuCalc: Double = 0.0
    val calendar = Calendar.getInstance()
    calendar.time = reserva.dataInici

    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH) // Los meses en Calendar van de 0 (enero) a 11 (diciembre)

    // Temporada de invierno: del 31 de octubre al 15 de abril
    val isWinter = (month == Calendar.OCTOBER && day >= 31) ||
            (month in Calendar.NOVEMBER..Calendar.DECEMBER) ||
            (month in Calendar.JANUARY..Calendar.MARCH) ||
            (month == Calendar.APRIL && day <=15)

    // Temporada de verano: del 1 de julio al 12 de septiembre
    val isSummer = (month == Calendar.JULY) ||
            (month == Calendar.AUGUST) ||
            (month == Calendar.SEPTEMBER && day <= 12)

    if(isWinter) {
        if (reserva.tipusHab == 1) {
            return 150.0
        } else if (reserva.tipusHab == 2) {
            return 200.0
        } else{
            return 250.0
        }
    }else{
        if (reserva.tipusHab == 1) {
            return 100.0
        } else if (reserva.tipusHab == 2) {
            return 150.0
        } else{
            return 200.0
        }
    }

}