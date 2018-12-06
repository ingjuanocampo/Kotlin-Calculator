package calculator.example.com.kotlincalculator.mvp.model

import org.junit.After
import org.junit.Test

import org.junit.Assert.*

class CalculatorModelTest {

    private val model : CalculatorModel = CalculatorModel()

    @After
    fun after() {
        model.clear()
    }

    @Test
    fun setOperatorWithoutActionTest() {
        model.setOperator(1.0f)

        assertEquals(1.0f, model.operator1)
        assertEquals(0.0f, model.operator2)
        assertEquals(CalculatorActions.NON_SELECTED, model.action)
    }

    @Test
    fun setOperatorWithActionTest() {
        model.action = CalculatorActions.MULTI
        model.setOperator(2.0f)

        assertEquals(0.0f, model.operator1)
        assertEquals(2.0f, model.operator2)
        assertEquals(CalculatorActions.MULTI, model.action)
    }

    @Test
    fun setActionTest() {
        model.action = CalculatorActions.DIV

        assertEquals(CalculatorActions.DIV, model.action)
        assertEquals(0.0f, model.operator1)
        assertEquals(0.0f, model.operator2)
    }

    @Test
    fun getExpressionWithNoActionTest() {
        model.setOperator(1.0f)

        assertEquals(model.getExpression(), "1.0 ")
    }

    @Test
    fun getExpressionWithActionDivTest() {
        model.setOperator(1.0f)
        model.action = CalculatorActions.DIV

        assertEquals(model.getExpression(), "1.0 /")
    }

    @Test
    fun getExpressionWithActionSumTest() {
        model.setOperator(123445.0f)
        model.action = CalculatorActions.SUM

        assertEquals(model.getExpression(), "123445.0 +")
    }

    @Test
    fun getExpressionWithActionMultiTest() {
        model.setOperator(67897.0f)
        model.action = CalculatorActions.MULTI

        assertEquals(model.getExpression(), "67897.0 *")
    }

    @Test
    fun getExpressionWithActionRestTest() {
        model.setOperator(123131.0f)
        model.action = CalculatorActions.MULTI

        assertEquals(model.getExpression(), "123131.0 *")
    }

    @Test
    fun getResultSumOperationTest() {
        model.setOperator(2.0f)
        model.action = CalculatorActions.SUM
        model.setOperator(2.0f)

        assertEquals(model.getResult(), "4.0")
        assertEquals(model.getExpression(), "4.0 ")
    }

    @Test
    fun getResultRestOperationTest() {
        model.setOperator(2.0f)
        model.action = CalculatorActions.REST
        model.setOperator(2.0f)

        assertEquals(model.getResult(), "0.0")
        assertEquals(model.getExpression(), "0.0 ")
    }

    @Test
    fun getResultMultiOperationTest() {
        model.setOperator(2.0f)
        model.action = CalculatorActions.MULTI
        model.setOperator(16.0f)

        assertEquals(model.getResult(), "32.0")
        assertEquals(model.getExpression(), "32.0 ")
    }

    @Test
    fun getResultDivOperationTest() {
        model.setOperator(16.0f)
        model.action = CalculatorActions.DIV
        model.setOperator(2.0f)

        assertEquals(model.getResult(), "8.0")
        assertEquals(model.getExpression(), "8.0 ")
    }

    @Test
    fun getResultDivByZeroOperationTest() {
        model.setOperator(16.0f)
        model.action = CalculatorActions.DIV
        model.setOperator(0.0f)

        assertEquals(model.getResult(), "0.0")
        assertEquals(model.getExpression(), "0.0 ")
    }

    @Test
    fun getResultDivZeroOperationTest() {
        model.setOperator(0.0f)
        model.action = CalculatorActions.DIV
        model.setOperator(2.0f)

        assertEquals(model.getResult(), "0.0")
        assertEquals(model.getExpression(), "0.0 ")
    }

    @Test
    fun clearTest() {
        model.setOperator(0.0f)
        model.action = CalculatorActions.DIV
        model.setOperator(2.0f)
        model.clear()

        assertEquals(CalculatorActions.NON_SELECTED, model.action)
        assertEquals(0.0f, model.operator1)
        assertEquals(0.0f, model.operator2)
    }
}