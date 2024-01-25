package com.reinosa.trivial.model

fun questList(dificultad: String): List<Pregunta> {

    // Lista de preguntas fáciles
    val listaDePreguntasFaciles: List<Pregunta> = listOf(
        Pregunta("¿Cuál es el color del cielo durante el día?", "A) Rojo", "B) Verde", "C) Azul", "D) Amarillo", Opcion.C),
        Pregunta("¿Cuántos dedos tiene una mano?", "A) Tres", "B) Cinco", "C) Seis", "D) Diez", Opcion.B),
        Pregunta("¿Cuál es el resultado de 2 + 2?", "A) 3", "B) 4", "C) 5", "D) 6", Opcion.B),
        Pregunta("¿Cuál es el mes de diciembre?", "A) Primavera", "B) Verano", "C) Otoño", "D) Invierno", Opcion.D),
        Pregunta("¿Cuál es el planeta más grande del sistema solar?", "A) Marte", "B) Júpiter", "C) Venus", "D) Saturno", Opcion.B),
        Pregunta("¿Cuál es el día después del viernes?", "A) Sábado", "B) Domingo", "C) Lunes", "D) Miércoles", Opcion.A),
        Pregunta("¿Cuántos minutos hay en una hora?", "A) 30", "B) 60", "C) 90", "D) 120", Opcion.B),
        Pregunta("¿Cuántas patas tiene un gato?", "A) 2", "B) 4", "C) 6", "D) 8", Opcion.B),
        Pregunta("¿Cuál es el animal más grande del mundo?", "A) Elefante", "B) Ballena Azul", "C) Jirafa", "D) Tigre", Opcion.B),
        Pregunta("¿Cuál es el resultado de 10 - 5?", "A) 2", "B) 5", "C) 10", "D) 15", Opcion.B),
        Pregunta("¿Cuántos días tiene el mes de marzo?", "A) 28", "B) 29", "C) 30", "D) 31", Opcion.D),
        Pregunta("¿Cuál es el océano más grande?", "A) Atlántico", "B) Índico", "C) Pacífico", "D) Ártico", Opcion.C),
        Pregunta("¿Cuál es el resultado de 3 x 4?", "A) 6", "B) 9", "C) 12", "D) 15", Opcion.C),
        Pregunta("¿Cuál es el continente donde se encuentra Egipto?", "A) Asia", "B) África", "C) Europa", "D) América", Opcion.B),
        Pregunta("¿Cuál es el idioma oficial de Brasil?", "A) Español", "B) Inglés", "C) Francés", "D) Portugués", Opcion.D)
    )

// Lista de preguntas normales
    val listaDePreguntasNormales: List<Pregunta> = listOf(
        Pregunta("¿Cuál es la capital de Francia?", "A) Madrid", "B) París", "C) Roma", "D) Berlín", Opcion.B),
        Pregunta("¿Cuál es el río más largo del mundo?", "A) Amazonas", "B) Nilo", "C) Yangtsé", "D) Misisipi", Opcion.A),
        Pregunta("¿Quién escribió 'Romeo y Julieta'?", "A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Fyodor Dostoevsky", Opcion.B),
        Pregunta("¿Cuántos elementos químicos hay en la tabla periódica?", "A) 92", "B) 100", "C) 118", "D) 150", Opcion.C),
        Pregunta("¿En qué año se fundó la ciudad de Nueva York?", "A) 1607", "B) 1620", "C) 1664", "D) 1776", Opcion.C),
        Pregunta("¿Cuál es la capital de Japón?", "A) Pekín", "B) Seúl", "C) Tokio", "D) Bangkok", Opcion.C),
        Pregunta("¿Quién pintó la Mona Lisa?", "A) Vincent van Gogh", "B) Leonardo da Vinci", "C) Pablo Picasso", "D) Michelangelo", Opcion.B),
        Pregunta("¿Cuál es el tercer planeta del sistema solar?", "A) Marte", "B) Venus", "C) Tierra", "D) Júpiter", Opcion.C),
        Pregunta("¿En qué año se inventó la imprenta?", "A) 1400", "B) 1450", "C) 1500", "D) 1550", Opcion.B),
        Pregunta("¿Cuántas caras tiene un cubo?", "A) 4", "B) 6", "C) 8", "D) 12", Opcion.B),
        Pregunta("¿Cuál es la moneda de Canadá?", "A) Dólar canadiense", "B) Euro", "C) Peso mexicano", "D) Yen japonés", Opcion.A),
        Pregunta("¿Cuál es el animal más rápido del mundo?", "A) León", "B) Guepardo", "C) Águila", "D) Tiburón", Opcion.B),
        Pregunta("¿En qué año se produjo la Revolución Rusa?", "A) 1905", "B) 1917", "C) 1923", "D) 1931", Opcion.B),
        Pregunta("¿Cuál es el símbolo químico del oro?", "A) Au", "B) Ag", "C) Fe", "D) Cu", Opcion.A),
        Pregunta("¿Cuál es el océano más profundo?", "A) Atlántico", "B) Índico", "C) Pacífico", "D) Ártico", Opcion.C)
    )

// Lista de preguntas difíciles
    val listaDePreguntasDificiles: List<Pregunta> = listOf(
        Pregunta("¿Cuál es la velocidad de la luz?", "A) 300,000 km/s", "B) 150,000 km/s", "C) 500,000 km/s", "D) 1,000,000 km/s", Opcion.A),
        Pregunta("¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?", "A) 1945", "B) 1919", "C) 1955", "D) 2000", Opcion.A),
        Pregunta("¿Cuántos huesos tiene el cuerpo humano?", "A) 106", "B) 206", "C) 306", "D) 406", Opcion.B),
        Pregunta("¿Cuál es el quinto planeta del sistema solar?", "A) Marte", "B) Júpiter", "C) Venus", "D) Saturno", Opcion.B),
        Pregunta("¿Quién descubrió América en 1492?", "A) Cristóbal Colón", "B) Marco Polo", "C) Hernán Cortés", "D) Francisco Pizarro", Opcion.A),
        Pregunta("¿En qué año se firmó la Declaración de Independencia de Estados Unidos?", "A) 1776", "B) 1789", "C) 1801", "D) 1812", Opcion.A),
        Pregunta("¿Cuál es la capital de Australia?", "A) Sídney", "B) Canberra", "C) Melbourne", "D) Brisbane", Opcion.B),
        Pregunta("¿Quién escribió 'Cien años de soledad'?", "A) Gabriel García Márquez", "B) Mario Vargas Llosa", "C) Julio Cortázar", "D) Isabel Allende", Opcion.A),
        Pregunta("¿Cuántos kilómetros tiene el Monte Everest?", "A) 7,000 km", "B) 8,848 km", "C) 10,000 km", "D) 12,345 km", Opcion.B),
        Pregunta("¿En qué año se inauguró la Torre Eiffel?", "A) 1889", "B) 1900", "C) 1925", "D) 1950", Opcion.A),
        Pregunta("¿Cuál es la capital de Sudáfrica?", "A) Ciudad del Cabo", "B) Johannesburgo", "C) Pretoria", "D) Durban", Opcion.C),
        Pregunta("¿Cuál es el símbolo químico del silicio?", "A) Si", "B) Se", "C) Sn", "D) Sr", Opcion.A),
        Pregunta("¿En qué año se celebró la primera Copa Mundial de la FIFA?", "A) 1922", "B) 1930", "C) 1940", "D) 1950", Opcion.B),
        Pregunta("¿Cuál es la capital de Islandia?", "A) Oslo", "B) Estocolmo", "C) Reikiavik", "D) Helsinki", Opcion.C),
        Pregunta("¿Quién escribió 'El principito'?", "A) Antoine de Saint-Exupéry", "B) J.K. Rowling", "C) Charles Dickens", "D) Fyodor Dostoevsky", Opcion.A)
    )
    return when (dificultad) {
        "Facil" -> listaDePreguntasFaciles
        "Normal" -> listaDePreguntasNormales
        "Dificil" -> listaDePreguntasDificiles
        else -> listOf()
    }
}