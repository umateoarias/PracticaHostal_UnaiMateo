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
    ),
    Servei(
        "Passejos a cavall",
        "https://www.totiaranalquilerbaqueira.com/blog/wp-content/uploads/2024/08/paseo-caballo-aran-grupo.jpg",
        "Gaudeix de tranquil·les passejades a cavall per camins i paisatges del Val d'Aran, ideals per a famílies i amants de la natura."
    ),
    Servei(
        "Rutes guiades de senderisme",
        "https://www.totiaranalquilerbaqueira.com/blog/wp-content/uploads/2024/08/RUTA-SENDERISMO-ARAN.jpg",
        "Explora les muntanyes i valls del Val d'Aran amb un guia expert que t'ajudarà a descobrir els racons més espectaculars de la regió."
    ),
    Servei(
        "Taller de cuina aranesa",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Tourin.jpg/640px-Tourin.jpg",
        "Descobreix els secrets de la gastronomia tradicional aranesa, com la preparació de l'olla aranesa o els plats típics amb ingredients locals."
    )
)
