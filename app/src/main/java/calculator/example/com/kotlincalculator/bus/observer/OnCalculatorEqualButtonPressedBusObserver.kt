package calculator.example.com.kotlincalculator.bus.observer

import com.globant.counter.utils.bus.observer.BusObserver

abstract class OnCalculatorEqualButtonPressedBusObserver : BusObserver<OnCalculatorEqualButtonPressedBusObserver.OnCalculatorEqualButtonPressed>
    (OnCalculatorEqualButtonPressed::class.java) {
    class OnCalculatorEqualButtonPressed
}