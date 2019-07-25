package com.alokomkar.base.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alokomkar.base.R
import com.alokomkar.base.common.BaseNavigationFragment
import com.alokomkar.base.data.Status
import com.alokomkar.base.extensions.*
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : BaseNavigationFragment() {

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_task_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskViewModel = activityViewModels {
            observe(getAllTasks()) {
                it?.apply {
                    pbLoading.changeVisibility(status == Status.LOADING )
                    if( status == Status.ERROR ) {
                        view.showSnackbar(R.string.error_unable_to_fetch_tasks)
                    }
                    else if( status == Status.SUCCESS ) {
                        rvTasks.apply {
                            adapter = TasksRvAdapter().apply {
                                onEmptyOrNot = {
                                    tvEmptyView.changeVisibility(it)
                                }
                                onItemClickListener = { _, _, item ->
                                    navigateToTaskDetails(item.taskId)
                                }
                                addAll(data ?: ArrayList() )
                            }
                        }
                    }
                }
            }
        }

        fabAddTask.setOnClickListener {
            navigateToTaskDetails("")
        }
    }

    private fun navigateToTaskDetails( taskId : String ) {
        if( isCurrentDestination(R.id.taskListFragment) ) {
            findNavController().navigate(
                TaskListFragmentDirections.actionTaskListFragmentToTaskDetailsFragment(
                    taskId
                )
            )
        }
    }
}
