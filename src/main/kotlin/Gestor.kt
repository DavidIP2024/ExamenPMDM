

package org.danielcastelao.dam

// Nivel en el que se encuentra el mecanismo
var nivel_actual: Int = 0

// Estado actual del mecanismo
var estado_actual: Estados = Estados.Idle

// Botón para ir al nivel 0
fun nivel_0(): Int {
    if (estado_actual == Estados.Idle && nivel_actual == 1) {
        estado_actual = Estados.MovingDOWN
        nivel_actual = 2
    }

    return nivel_actual
}

// Botón para ir al nivel 1
fun nivel_1(): Int {
    if (estado_actual == Estados.Idle && nivel_actual == 0) {
        estado_actual = Estados.MovingUP
        nivel_actual = 2
    }

    return nivel_actual
}

/**
 * Gestiona el cambio de estados.
 */
fun gestor(): Int {
    when (estado_actual) {
        Estados.Idle -> {
            // El mecanismo permanece parado.
        }

        Estados.MovingUP -> {
            nivel_actual = 1
            estado_actual = Estados.Idle
        }

        Estados.MovingDOWN -> {
            nivel_actual = 0
            estado_actual = Estados.Idle
        }

        Estados.Error -> {
            nivel_actual = -1
        }
    }

    return nivel_actual
}

// Activa el estado de error
fun activarError(): Int {
    estado_actual = Estados.Error
    nivel_actual = -1

    return nivel_actual
}
