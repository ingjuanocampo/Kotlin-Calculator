package calculator.example.com.kotlincalculator.mvp.view

import android.app.Activity

import java.lang.ref.WeakReference

abstract class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    open val activity: Activity?
        get() = activityRef?.get()

}
