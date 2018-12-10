package calculator.example.com.kotlincalculator.mvp.model

class CalculatorModel {

    var action: CalculatorActions = CalculatorActions.NON_SELECTED
    var operator1: Float = 0.0F
    var operator2: Float = 0.0F

    fun setOperator(value: Float) {
        if (action == CalculatorActions.NON_SELECTED) {
            operator1 = value
        } else {
            operator2 = value
        }
    }

    fun getExpression(): String {
        return "$operator1 ${action.value}"
    }

    fun getResult(): String {
        try {
            return "${doCalculation()}"
        } catch (e: IllegalStateException) {
            return "$operator1"
        }
    }

    fun clear() {
        action = CalculatorActions.NON_SELECTED
        operator1 = 0.0F
        operator2 = 0.0F
    }

    @Throws(IllegalStateException::class)
    private fun doCalculation(): Float {
        if (action == CalculatorActions.NON_SELECTED) {
            throw IllegalStateException()
        }

        operator1 = when (action) {
            CalculatorActions.DIV -> (if (operator2 != 0.0F) operator1 / operator2 else 0.0F)
            CalculatorActions.MULTI -> operator1 * operator2
            CalculatorActions.REST -> operator1 - operator2
            CalculatorActions.SUM -> operator1 + operator2
            else -> 0.0F
        }
        operator2 = 0.0F

        action = CalculatorActions.NON_SELECTED // reset action with latest result
        return operator1

    }

}