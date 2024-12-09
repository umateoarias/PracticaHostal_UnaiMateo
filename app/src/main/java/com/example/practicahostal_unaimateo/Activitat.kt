package com.example.practicahostal_unaimateo

data class Activitat(
    val nom: String,
    val img_url: String,
    val descripcio: String
)

val activitats = listOf(
    Activitat(
        "Visita al Museu Eth Corrau",
        "https://www.fotopaises.com/Fotos-Paises/t1024/2020/12/17/2515_1608145341.jpg",
        "Explora una col·lecció d’eines i objectes tradicionals que mostren la vida rural dels Pirineus."
    ),
    Activitat(
        "Passejada pel nucli històric",
        "https://catalunyaturisme.cat/wp-content/uploads/bagergue-4.jpg",
        "Descobreix aquest pintoresc poble, considerat un dels més bonics d’Espanya, amb els seus carrers empedrats i balcons florits."
    ),
    Activitat(
        "Ruta al Pla de Beret",
        "https://i.ytimg.com/vi/BE5x2kWNIoI/sddefault.jpg",
        "Fes una caminada des de Bagergue fins a aquest punt emblemàtic de la Vall d’Aran, amb vistes panoràmiques."
    ),
    Activitat(
        "Degustació a Tauerna Urtau",
        "https://www.urtau.com/wp-content/uploads/2019/11/Urtau_arties_s02.jpg",
        "Tasta plats locals en aquest restaurant tradicional amb productes de la regió."
    ),
    Activitat(
        "Senderisme pel Val d’Unhola",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Arriu_Unh%C3%B2la.jpg/1200px-Arriu_Unh%C3%B2la.jpg",
        "Gaudeix d’un recorregut tranquil i natural, amb rius i prats en un entorn de muntanya."
    ),
    Activitat(
        "Visita a l’església de Sant Fèlix",
        "https://www.turismodeobservacion.com/media/fotografias/sant-felix-de-bagergue-val-daran-70758-xl.jpg",
        "Admira aquesta petita església romànica que data del segle XIII, plena d’encant històric."
    ),
    Activitat(
        "Esquí o raquetes de neu a l’hivern",
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgUYHQXN1gFmJSOqTtBq4YqXV2i6T72IDzjtWEbdRtOdfchThGdxGIt9KWmi6efS0LWf2bjCXgxM-PamsP9bn9uT48k-WdBJYlw6jLphEuYMQ_4ZZknKT7RCoLZbr1JKW3hLNdZP0fJhg/s1600/ascension.jpg",
        "A poca distància de Baqueira-Beret, és ideal per a esports d’hivern amb accés fàcil a les pistes."
    ),
)
