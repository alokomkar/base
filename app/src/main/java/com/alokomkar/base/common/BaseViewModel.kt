package com.alokomkar.base.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.alokomkar.base.TaskApplication

abstract class BaseViewModel( application: Application ) : AndroidViewModel(application) {
    val taskApplication : TaskApplication = application as TaskApplication
}