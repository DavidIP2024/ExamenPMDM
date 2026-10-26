
package org.danielcastelao.dam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HaloTest {

    @BeforeEach
    fun reiniciar() {
        nivel_actual = 0
        estado_actual = Estados.Idle
    }

    @Test
    fun empiezaEnNivelCero() {
        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun subirIniciaMovimiento() {
        nivel_1()

        assertEquals(2, nivel_actual)
        assertEquals(Estados.MovingUP, estado_actual)
    }

    @Test
    fun terminarSubidaLlegaAlNivelUno() {
        nivel_1()
        gestor()

        assertEquals(1, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun bajarIniciaMovimiento() {
        nivel_actual = 1

        nivel_0()

        assertEquals(2, nivel_actual)
        assertEquals(Estados.MovingDOWN, estado_actual)
    }

    @Test
    fun terminarBajadaLlegaAlNivelCero() {
        nivel_actual = 1
        nivel_0()
        gestor()

        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun noSubeSiYaEstaEnNivelUno() {
        nivel_actual = 1

        nivel_1()

        assertEquals(1, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun noBajaSiYaEstaEnNivelCero() {
        nivel_0()

        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_actual)
    }

    @Test
    fun noAceptaOtroMovimientoMientrasSeMueve() {
        nivel_1()
        nivel_0()

        assertEquals(2, nivel_actual)
        assertEquals(Estados.MovingUP, estado_actual)
    }

    @Test
    fun activarErrorCambiaEstadoYNivel() {
        activarError()

        assertEquals(-1, nivel_actual)
        assertEquals(Estados.Error, estado_actual)
    }

    @Test
    fun noSeMueveDesdeError() {
        activarError()

        nivel_0()
        nivel_1()
        gestor()

        assertEquals(-1, nivel_actual)
        assertEquals(Estados.Error, estado_actual)
    }
}
