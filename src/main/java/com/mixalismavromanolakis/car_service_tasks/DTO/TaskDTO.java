package com.mixalismavromanolakis.car_service_tasks.DTO;

import com.mixalismavromanolakis.car_service_tasks.Entities.Task;

public class TaskDTO {

    public int taskId;
    public String title;
    public String description;
    public String statusOfTask;
    public String typeOfTask;
    public Integer mechanicId;

    public Integer getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Integer mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String mechanicOfTaskFirstName;
    public String mechanicOfTaskLastName;
    public String mechanicOfTaskEmailAddress;

    public TaskDTO() {
    }

    public TaskDTO(Task taskEntity) {
        this.taskId = taskEntity.getTaskId();
        this.title = taskEntity.getTitle();
        this.description = taskEntity.getDescription();
        this.statusOfTask = taskEntity.getStatusOfTask().getStatusName();
        this.typeOfTask = taskEntity.getTypeOfTask().getName();
        this.mechanicId = taskEntity.getMechanicOfTask().getMechanicId();
        this.mechanicOfTaskFirstName = taskEntity.getMechanicOfTask().getFirstName();
        this.mechanicOfTaskLastName = taskEntity.getMechanicOfTask().getLastName();
        this.mechanicOfTaskEmailAddress = taskEntity.getMechanicOfTask().getEmailAddress();
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusOfTask() {
        return statusOfTask;
    }

    public void setStatusOfTask(String statusOfTask) {
        this.statusOfTask = statusOfTask;
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(String typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getMechanicOfTaskFirstName() {
        return mechanicOfTaskFirstName;
    }

    public void setMechanicOfTaskFirstName(String mechanicOfTaskFirstName) {
        this.mechanicOfTaskFirstName = mechanicOfTaskFirstName;
    }

    public String getMechanicOfTaskLastName() {
        return mechanicOfTaskLastName;
    }

    public void setMechanicOfTaskLastName(String mechanicOfTaskLastName) {
        this.mechanicOfTaskLastName = mechanicOfTaskLastName;
    }

    public String getMechanicOfTaskEmailAddress() {
        return mechanicOfTaskEmailAddress;
    }

    public void setMechanicOfTaskEmailAddress(String mechanicOfTaskEmailAddress) {
        this.mechanicOfTaskEmailAddress = mechanicOfTaskEmailAddress;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusOfTask='" + statusOfTask + '\'' +
                ", typeOfTask='" + typeOfTask + '\'' +
                ", mechanicId=" + mechanicId +
                ", mechanicOfTaskFirstName='" + mechanicOfTaskFirstName + '\'' +
                ", mechanicOfTaskLastName='" + mechanicOfTaskLastName + '\'' +
                ", mechanicOfTaskEmailAddress='" + mechanicOfTaskEmailAddress + '\'' +
                '}';
    }
}
