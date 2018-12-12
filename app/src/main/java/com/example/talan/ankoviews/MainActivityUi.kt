package com.example.talan.ankoviews

import android.graphics.Rect
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.talan.MainActivity
import com.example.talan.PaymentMethodsAdapter
import com.example.talan.R
import com.example.talan.recyclerView
import org.jetbrains.anko.*

/**
 * Created by vlad on 11.12.18.
 */

class MainActivityUi(
        private val mAdapter: PaymentMethodsAdapter
) : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = ui.let { ankoContext ->
        ankoContext.verticalLayout {
            backgroundColor = ContextCompat.getColor(ankoContext.ctx, R.color.grey)
            toolbar {
                backgroundColor = ContextCompat.getColor(ankoContext.ctx, R.color.white)
                title = ankoContext.ctx.getString(R.string.title_payment_methods)
                setTitleTextAppearance(ankoContext.ctx, R.style.ToolbarTitle)
                elevation = dip(4f).toFloat()
                ui.owner.setActionBar(this)
            }

            recyclerView {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(ankoContext.ctx)
                addItemDecoration(object: RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        outRect.left = 0
                        outRect.right = 0
                        outRect.bottom = 0
                        outRect.top = if (parent.getChildAdapterPosition(view) == 0) dip(12) else dip(1)
                    }
                })
            }.lparams(matchParent, matchParent)
        }
    }
}