package com.alokomkar.base.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.isCurrentDestination(@IdRes destination: Int) =
    findNavController().currentDestination == null || findNavController().currentDestination?.id == destination