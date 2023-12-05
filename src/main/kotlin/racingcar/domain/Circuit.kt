package racingcar.domain

import racingcar.utils.RandomGenerator
import racingcar.utils.StringListSplitter

class Circuit(carNames: String, private val raceRound: Int) {
    private val cars = registerCars(carNames)

    private fun registerCars(carNames: String): List<Car> {
        val carNameList = StringListSplitter.splitByCommaToStringList(carNames)
        val cars = mutableListOf<Car>()
        cars.addAll(carNameList.map { Car(it) })
        return cars.toList()
    }

    fun startRace() {
        repeat(raceRound) {
            playRound()
            printRacingStatus()
        }
    }

    private fun playRound() {
        cars.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printRacingStatus() {
        cars.forEach { println(it) }
        println()
    }

    fun getCarList(): List<Car> {
        return cars.toList()
    }
}