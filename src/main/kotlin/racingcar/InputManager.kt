package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.CarNameValidator
import racingcar.validator.RaceRoundValidator

class InputManager {
    private val carNameValidator = CarNameValidator()
    private val raceRoundValidator = RaceRoundValidator()

    fun getCarNameFromUser(): String {
        println(CAR_NAMES_INPUT_PROMPT_MESSAGE)
        return getValidInput { carNameValidator.validate(it) }
    }

    fun getRaceRoundFromUser(): Int {
        println(RACE_ROUND_INPUT_PROMPT_MESSAGE)
        return getValidInput { raceRoundValidator.validate(it) }.toInt()
    }

    private fun getValidInput(validate: (String) -> Unit): String {
        return try {
            val input = Console.readLine().trim()
            validate(input)
            input
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidInput(validate)
        }
    }

    companion object {
        private const val CAR_NAMES_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val RACE_ROUND_INPUT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}