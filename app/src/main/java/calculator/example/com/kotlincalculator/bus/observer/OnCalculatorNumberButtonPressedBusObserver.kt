package calculator.example.com.kotlincalculator.bus.observer

import com.globant.counter.utils.bus.observer.BusObserver

abstract class OnCalculatorNumberButtonPressedBusObserver : BusObserver<OnCalculatorNumberButtonPressedBusObserver.OnCalculatorNumberButtonPressed>
    (OnCalculatorNumberButtonPressed::class.java) {

    class OnCalculatorNumberButtonPressed (var number: Float = 0.0F)
}
