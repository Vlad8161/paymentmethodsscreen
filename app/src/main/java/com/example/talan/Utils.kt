package com.example.talan

import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

/**
 * Created by vlad on 11.12.18.
 */

fun ViewManager.recyclerView() = recyclerView { }
inline fun ViewManager.recyclerView(init: (@AnkoViewDslMarker RecyclerView).() -> Unit) = ankoView({ RecyclerView(it) }, 0, init)
