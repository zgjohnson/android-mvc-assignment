package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Map;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.
    private HashMap<Integer, Task> taskList;
    private Integer maxKey = 1;

    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object

    // TODO 04. Define the class constructor and the corresponding getters and setters.

    public TaskList() {
        taskList = new HashMap<>();
    }

    public HashMap<Integer, Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(HashMap<Integer, Task> taskList) {
        this.taskList = taskList;
    }

    public Integer getMaxKey() {
        return maxKey;
    }

    public void setMaxKey(Integer maxKey) {
        this.maxKey = maxKey;
    }

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void add(String taskDescription){
        //Task newTask = new Task(false, taskDescription);
        Integer id;
        id = this.getMaxKey();
        this.taskList.put(id, new Task(false,taskDescription));
        this.setMaxKey(++id);
    }


    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line

    public String toFormattedString(){

        String textListFormat = "";
        for(Map.Entry<Integer, Task> entry: taskList.entrySet()){
          String id = entry.getKey().toString();
          String taskDescription = entry.getValue().getTaskDescription();
          String isDone = "";
          if(entry.getValue().getComplete())
          {
              isDone = "Done";
          }
          textListFormat+=(id + "-" + taskDescription + "\r\t" + isDone + "\r\n" );
         }
      return textListFormat;
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.

    public void delete(String idToDelete){
       this.taskList.remove(Integer.parseInt(idToDelete));
    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.

    public void markDone(String idToBeDone){

        this.taskList.get(Integer.parseInt(idToBeDone)).setComplete(true);

    }
}
