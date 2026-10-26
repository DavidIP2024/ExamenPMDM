
package org.danielcastelao.dam


var nivel_actual: Int = 0

var estado_actual: Estados = Estados.Idle


fun nivel_0(): Int {
    if (estado_actual == Estados.Idle && nivel_actual == 1) {
        estado_actual = Estados.MovingDOWN
        nivel_actual = 2
    }

    return nivel_actual
}


fun nivel_1(): Int {
    if (estado_actual == Estados.Idle && nivel_actual == 0) {
        estado_actual = Estados.MovingUP
        nivel_actual = 2
    }

    return nivel_actual
}


fun gestor(): Int {
    when (estado_actual) {
        Estados.Idle -> {
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






