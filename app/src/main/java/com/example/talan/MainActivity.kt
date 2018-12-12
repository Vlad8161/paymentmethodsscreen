package com.example.talan

import android.app.Activity
import android.os.Bundle
import com.example.talan.ankoviews.MainActivityUi
import org.jetbrains.anko.setContentView

class MainActivity : Activity() {
    private val adapter = PaymentMethodsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.data = listOf(
                PaymentMethodsAdapter.PaymentMethod("Наличный рассчет"),
                PaymentMethodsAdapter.PaymentMethod("Ипотека"),
                PaymentMethodsAdapter.PaymentMethod("Рассрочка"),
                PaymentMethodsAdapter.PaymentMethod("Trade-in"),
                PaymentMethodsAdapter.PaymentMethod("Материнский капитал")
        )

        MainActivityUi(adapter).setContentView(this)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}
