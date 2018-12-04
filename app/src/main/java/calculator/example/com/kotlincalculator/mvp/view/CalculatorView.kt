package calculator.example.com.kotlincalculator.mvp.view

import android.app.Activity
import android.text.TextUtils
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorActionButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorClearButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorEqualButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorNumberButtonPressedBusObserver
import calculator.example.com.kotlincalculator.mvp.model.CalculatorActions
import com.globant.counter.utils.bus.RxBus
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorView(activity: Activity) : ActivityView(activity) {

    fun setExpression(expression: String) {
        activity?.text_expression?.text = expression
    }

    init {
        activity.btn_sum.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.SUM))

        }

        activity.btn_div.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.DIV))

        }

        activity.btn_multi.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.MULTI))

        }

        activity.btn_rest.setOnClickListener {
            getInput()
            RxBus.post(OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed(CalculatorActions.REST))

        }

        activity.btn_equal.setOnClickListener {
           getInput()
            RxBus.post(OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed())
        }

        activity.btn_clear.setOnClickListener {
            RxBus.post(OnCalculatorClearButtonPressedBusObserver.OnCalculatorClearButton())
        }

    }

    private fun getInput() {
        var input = activity?.edit_text_input?.text.toString()
        if (!TextUtils.isEmpty(input)) {
            RxBus.post(OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed(input.toFloat()))
        }
        activity?.edit_text_input?.setText("")
    }

    fun clear() {
        activity?.edit_text_input?.setText("")
        activity?.text_expression?.text = ""
    }

}