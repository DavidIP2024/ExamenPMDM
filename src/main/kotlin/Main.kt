
package org.danielcastelao.dam

fun main() {
    println("Estado inicial: $estado_actual")
    println("Nivel inicial: $nivel_actual")

    nivel_1()
    println("Después de pulsar nivel_1: $estado_actual")
    println("Nivel actual: $nivel_actual")

    gestor()
    println("Al terminar la subida: $estado_actual")
    println("Nivel actual: $nivel_actual")

    nivel_0()
    println("Después de pulsar nivel_0: $estado_actual")
    println("Nivel actual: $nivel_actual")

    gestor()
    println("Al terminar la bajada: $estado_actual")
    println("Nivel actual: $nivel_actual")
}
