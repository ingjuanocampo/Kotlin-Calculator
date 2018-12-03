package calculator.example.com.kotlincalculator.bus.observer

import calculator.example.com.kotlincalculator.mvp.model.CalculatorActions
import com.globant.counter.utils.bus.observer.BusObserver

abstract class OnCalculatorActionButtonPressedBusObserver : BusObserver<OnCalculatorActionButtonPressedBusObserver.OnCalculatorActionButtonPressed>
    (OnCalculatorActionButtonPressed::class.java) {

    class OnCalculatorActionButtonPressed (var action: CalculatorActions)
}