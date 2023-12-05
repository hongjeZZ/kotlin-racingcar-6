package racingcar

import racingcar.domain.RacingCarGame

fun main() {
    val game = RacingCarGame(InputManager(), OutputManager())
    game.startGame()
}