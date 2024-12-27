package com.dproject.todoapp.addtasks.domain

import com.dproject.todoapp.addtasks.data.TaskRepository
import com.dproject.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) {

    suspend operator fun invoke(taskModel: TaskModel) = taskRepository.add(taskModel)
}