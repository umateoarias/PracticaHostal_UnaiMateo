package com.example.practicahostal_unaimateo

data class Servei(
    val nom: String,
    val img_url: String,
    val descripcio: String
)

val serveis = listOf(
    Servei(
        "Curs d'astrofotografia",
        "https://www.ngenespanol.com/wp-content/uploads/2023/06/astrofotografia.jpeg",
        "Aprèn les tècniques essencials per capturar l'univers amb la càmera: des de l'ús de l'equip fins a l'edició d'imatges per crear espectaculars fotografies del cel nocturn."
    )
)
