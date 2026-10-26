
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

