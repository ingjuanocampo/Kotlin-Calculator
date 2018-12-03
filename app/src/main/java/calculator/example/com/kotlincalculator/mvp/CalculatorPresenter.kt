package calculator.example.com.kotlincalculator.mvp

import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorActionButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorEqualButtonPressedBusObserver
import calculator.example.com.kotlincalculator.bus.observer.OnCalculatorNumberButtonPressedBusObserver
import com.globant.counter.utils.bus.RxBus

class CalculatorPresenter (model : CalculatorModel, view :CalculatorView) {

    init {

        val activity = view.activity
        if (activity != null) {
            RxBus.subscribe(activity, object : OnCalculatorActionButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorActionButtonPressed) {
                    model.action = value.action
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object : OnCalculatorNumberButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorNumberButtonPressed) {
                    model.setOperator(value.number)
                    view.setExpression(model.getExpression())
                }
            })

            RxBus.subscribe(activity, object  : OnCalculatorEqualButtonPressedBusObserver() {
                override fun onEvent(value: OnCalculatorEqualButtonPressed) {
                    view.setExpression(model.getResult())
                }
            })

        }
    }



}