package com.alokomkar.base.extensions

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.alokomkar.base.common.BaseViewModel
import com.google.android.material.snackbar.Snackbar

fun Fragment.isCurrentDestination(@IdRes destination: Int) =
    findNavController().currentDestination == null || findNavController().currentDestination?.id == destination

@MainThread
inline fun <reified VM : BaseViewModel> Fragment.activityViewModels(body: VM.() -> Unit): VM =
    ViewModelProviders.of(this.requireActivity()).get(VM::class.java).apply(body)

fun <L : LiveData<T>, T : Any> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.changeVisibility( isVisible : Boolean ) {
    if( isVisible ) show() else hide()
}

fun View.showSnackbar( message : Int ) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}
