package com.alokomkar.base


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alokomkar.base.extensions.isCurrentDestination
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_task_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabAddTask.setOnClickListener {
            if( isCurrentDestination(R.id.taskListFragment) ) {
                findNavController().navigate(TaskListFragmentDirections.actionTaskListFragmentToTaskDetailsFragment(""))
            }
        }
    }
}
