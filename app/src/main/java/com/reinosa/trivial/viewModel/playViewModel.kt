package com.reinosa.trivial.viewModel

import com.reinosa.trivial.model.Pregunta
import com.reinosa.trivial.model.questList

class playViewModel(settingsViewModel: SettingsViewModel) {
    // Enumeración para representar el nivel de dificultad
    enum class NivelDificultad {
        FACIL,
        NORMAL,
        DIFICIL
    }

     private val questListFacil: List<Pregunta> = questList("Facil")
        private val questListNormal: List<Pregunta> = questList("Normal")
        private val questListDificil: List<Pregunta> = questList("Dificil")

        private var nivelDificultadActual: NivelDificultad = NivelDificultad.FACIL
        private var rondaActual: Int = 1
        private var preguntaActual: Pregunta? = null

    init {
        // Inicializa la pregunta para la primera ronda
        actualizarPregunta()
    }

    fun obtenerPreguntaActual(): Pregunta? {
        return preguntaActual
    }

    fun avanzarRonda() {
        rondaActual++
        // Actualiza la pregunta para la siguiente ronda
        actualizarPregunta()
    }

    private fun actualizarPregunta() {
        // Lógica para obtener la pregunta según el nivel de dificultad y la ronda actual
        preguntaActual = when (nivelDificultadActual) {
            NivelDificultad.FACIL -> questListFacil.getOrNull(rondaActual - 1)
            NivelDificultad.NORMAL -> questListNormal.getOrNull(rondaActual - 1)
            NivelDificultad.DIFICIL -> questListDificil.getOrNull(rondaActual - 1)
        }

        // Verifica si es necesario cambiar el nivel de dificultad
        if (preguntaActual == null) {
            avanzarNivelDificultad()
            // Vuelve a intentar obtener la pregunta
            actualizarPregunta()
        }
    }

    private fun avanzarNivelDificultad() {
        // Lógica para avanzar al siguiente nivel de dificultad
        nivelDificultadActual = when (nivelDificultadActual) {
            NivelDificultad.FACIL -> NivelDificultad.NORMAL
            NivelDificultad.NORMAL -> NivelDificultad.DIFICIL
            NivelDificultad.DIFICIL -> NivelDificultad.FACIL // Puedes ajustar la lógica según tus necesidades
        }
        // Reinicia la ronda
        rondaActual = 1
    }
}