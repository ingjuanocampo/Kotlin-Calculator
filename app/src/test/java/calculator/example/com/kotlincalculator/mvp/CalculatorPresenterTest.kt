package calculator.example.com.kotlincalculator.mvp

import calculator.example.com.kotlincalculator.CalculatorActivity
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorActionButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorClearButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorEqualButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorNumberButtonPressedBusObserver
import calculator.example.com.kotlincalculator.mvp.model.CalculatorActions
import calculator.example.com.kotlincalculator.mvp.model.CalculatorModel
import calculator.example.com.kotlincalculator.mvp.view.CalculatorView
import com.globant.counter.utils.bus.RxBus
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class CalculatorPresenterTest {

    private var presenter: CalculatorPresenter? = null
    private var model: CalculatorModel? = null

    @Mock
    lateinit var view: CalculatorView
    @Mock
    lateinit var activity: CalculatorActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        model = CalculatorModel()

        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CalculatorPresenter(model!!, view)
    }

    @After
    fun after() {
        RxBus.clear(activity)
    }

    @Test
    fun sumOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))
        RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.SUM))
        verify(view, times(3)).setExpression(" 5.0 +")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorActions.SUM)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())

        assertEquals(model?.operator1, 10.0f)
        assertEquals(model?.operator2, 0.0f)

    }

    @Test
    fun restOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))
        RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.REST))
        verify(view, times(3)).setExpression(" 5.0 -")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorActions.REST)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.operator1, 0.0f)
        assertEquals(model?.operator2, 0.0f)
    }

    @Test
    fun multiOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))
        RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.MULTI))
        verify(view, times(3)).setExpression(" 5.0 *")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorActions.MULTI)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.operator1, 25.0f)
        assertEquals(model?.operator2, 0.0f)
    }

    @Test
    fun divOperationTest() {
        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(25.0f))
        RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.DIV))
        verify(view, times(3)).setExpression(" 5.0 /")

        RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(5.0f))

        assertEquals(model?.action, CalculatorActions.DIV)

        RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())


        assertEquals(model?.operator1, 5.0f)
        assertEquals(model?.operator2, 0.0f)
    }

    @Test
    fun clearOperationTest() {
        RxBus.post(OnCalculatorClearButtonPressedBusObserver.OnCalculatorClearButton())

        verify(view, atLeastOnce()).clear()
        assertEquals(model?.getResult(), "0.0")

    }

}