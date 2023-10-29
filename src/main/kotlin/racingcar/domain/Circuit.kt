package racingcar.domain

import racingcar.utils.Converter

class Circuit(carNames: String, private var moveCount: Int) {
    private var carList = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    fun startRace() {
        repeat(moveCount) {
            moveAndPrintCarPositions()
        }
    }

    fun getCarList(): MutableList<Car> {
        return carList
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach {
            val car = Car(it)
            carList.add(car)
        }
    }

    private fun moveAndPrintCarPositions() {
        moveOrStayAllCars()
        printCarPositions()
    }

    private fun moveOrStayAllCars() {
        carList.forEach { it.moveOrStay() }
    }

    private fun printCarPositions() {
        carList.forEach { it.showCurrentPositionWithName() }
        println()
    }
}