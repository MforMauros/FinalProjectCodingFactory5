package com.mixalismavromanolakis.car_service_tasks.DTO;

public class StatusDTO {

    public int statusId;
    public String statusName;
    public String statusOfCar;

    public StatusDTO() {
    }

    public StatusDTO(int statusId, String statusName, String statusOfCar) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusOfCar = statusOfCar;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusOfCar() {
        return statusOfCar;
    }

    public void setStatusOfCar(String statusOfCar) {
        this.statusOfCar = statusOfCar;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", statusOfCar='" + statusOfCar + '\'' +
                '}';
    }
}
