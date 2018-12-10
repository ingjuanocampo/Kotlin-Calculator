package calculator.example.com.kotlincalculator.mvp.model

enum class CalculatorActions (var value: String){
    SUM("+"), REST("-"), MULTI("*"), DIV("/"), NON_SELECTED("")
}