package calculator.example.com.kotlincalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import calculator.example.com.kotlincalculator.mvp.CalculatorPresenter
import calculator.example.com.kotlincalculator.mvp.model.CalculatorModel
import calculator.example.com.kotlincalculator.mvp.view.CalculatorView

open class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        CalculatorPresenter(CalculatorModel(), CalculatorView(this))

    }

}