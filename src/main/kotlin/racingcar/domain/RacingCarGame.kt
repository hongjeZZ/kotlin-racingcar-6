package racingcar.domain

import racingcar.InputManager
import racingcar.OutputManager

class RacingCarGame(
    private val inputManager: InputManager,
    private val outputManager: OutputManager,
) {
    private lateinit var circuit: Circuit

    fun startGame() {
        init()
        process()
        displayResult()
    }

    private fun init() {
        val carNames = inputManager.getCarNameFromUser()
        val raceRound = inputManager.getRaceRoundFromUser()
        circuit = Circuit(carNames, raceRound)
    }

    private fun process() {
        outputManager.printRaceStartMessage()
        circuit.startRace()
    }

    private fun displayResult() {
        val referee = Referee(circuit.getCarList())
        val winningCarNames = referee.getWinningCarNames()
        outputManager.printWinners(winningCarNames)
    }
}