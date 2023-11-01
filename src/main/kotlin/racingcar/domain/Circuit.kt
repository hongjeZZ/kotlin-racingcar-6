package racingcar.domain

import racingcar.utils.RandomGenerator
import racingcar.utils.StringListSplitter

class Circuit(carNames: String, private var raceRound: Int) {
    private val cars = mutableListOf<Car>()

    init {
        registerCars(carNames)
    }

    fun startRace() {
        repeat(raceRound) {
            playRound()
            printRacingStatus()
        }
    }

    fun getCarList(): List<Car> {
        return cars.toList()
    }

    private fun registerCars(carNames: String) {
        val carNameList = StringListSplitter.splitByCommaToStringList(carNames)
        cars.addAll(carNameList.map { Car(it) })
    }

    private fun playRound() {
        cars.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printRacingStatus() {
        cars.forEach { println(it) }
        println()
    }
}