package com.example.todoapp

import android.content.Context
import android.graphics.Paint
import android.os.Binder
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.FragmentNewTaskSheetBinding
import com.example.todoapp.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
) :RecyclerView.ViewHolder(binding.root)
{
   private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(taskItem:TaskItem)
    {
        binding.name.text = taskItem.name

        if(taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }
        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }
        binding.deleteBtn.setOnClickListener{
            clickListener.deleteTaskItem(taskItem)
            Toast.makeText(context, "Task Deleted", Toast.LENGTH_SHORT).show()

        }

        if(taskItem.dueTime() != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime())
        else
            binding.dueTime.text = " "
    }
}