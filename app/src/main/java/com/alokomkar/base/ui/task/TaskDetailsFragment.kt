package com.alokomkar.base.ui.task


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alokomkar.base.R
import com.alokomkar.base.common.BaseNavigationFragment

class TaskDetailsFragment : BaseNavigationFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_task_details, container, false)



}
