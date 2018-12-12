package com.example.talan

import android.graphics.Color
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Created by vlad on 11.12.18.
 */

class PaymentMethodsAdapter : RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodViewHolder>() {
    var data: List<PaymentMethod> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        holder.tvTitle.text = data[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder =
            AnkoContext.create(parent.context, parent)
                    .let { PaymentMethodUi().createView(it) }
                    .let { PaymentMethodViewHolder(it) }

    class PaymentMethod(
            val name: String
    )

    class PaymentMethodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(PaymentMethodUi.tvPaymentMethodId)
    }

    class PaymentMethodUi : AnkoComponent<ViewGroup> {
        companion object {
            val tvPaymentMethodId = 1
            val ivInfo = 2
        }

        override fun createView(ui: AnkoContext<ViewGroup>): View = ui.let { ankoContext ->
            ankoContext.constraintLayout {
                lparams(matchParent, dip(50))
                backgroundColorResource = R.color.white

                val tvPaymentMethod = textView {
                    id = tvPaymentMethodId
                    textColor = Color.BLACK
                    textSize = 16f
                }.lparams(0, wrapContent)

                val ivInfo = imageView(android.R.drawable.ic_dialog_info) {
                    id = ivInfo
                }.lparams(dip(20), dip(20))

                applyConstraintSet {
                    tvPaymentMethod {
                        connect(
                                TOP to TOP of PARENT_ID,
                                BOTTOM to BOTTOM of PARENT_ID,
                                LEFT to LEFT of PARENT_ID margin dip(16),
                                RIGHT to RIGHT of ivInfo
                        )
                    }

                    ivInfo {
                        connect(
                                TOP to TOP of PARENT_ID,
                                BOTTOM to BOTTOM of PARENT_ID,
                                RIGHT to RIGHT of PARENT_ID margin dip(16)
                        )
                    }
                }
            }
        }
    }
}