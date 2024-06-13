package com.mixalismavromanolakis.car_service_tasks.DTO;


import com.mixalismavromanolakis.car_service_tasks.Entities.Car;

public class CarDTO {

    public int carId;
    public String carName;
    public String description;
    public String statusName;
    public Integer mechanicId;
    public String mechanicOfCarFirstName;
    public String mechanicOfCarLastName;
    public String mechanicOfCarEmailAddress;

    public CarDTO() {
    }

    public CarDTO(Car carEntity) {
        this.carId = carEntity.getcarId();
        this.carName = carEntity.getName();
        this.description = carEntity.getDescription();
        this.mechanicOfCarLastName = carEntity.getmechanicOfCar().getLastName();
        this.mechanicOfCarFirstName = carEntity.getmechanicOfCar().getFirstName();
        this.mechanicOfCarEmailAddress = carEntity.getmechanicOfCar().getEmailAddress();

        if (carEntity.getmechanicOfCar() != null) {

            this.mechanicId = carEntity.getmechanicOfCar().getMechanicId();
        } else {
            this.mechanicId = 1;
        }

        if (carEntity.getStatusOfCar() != null) {

            this.statusName = carEntity.getStatusOfCar().getStatusName();
        } else {

            this.statusName = "Undefined Status";
        }
    }

    public Integer getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Integer mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getmechanicOfCarFirstName() {
        return mechanicOfCarFirstName;
    }

    public void setmechanicOfCarFirstName(String mechanicOfCarFirstName) {
        this.mechanicOfCarFirstName = mechanicOfCarFirstName;
    }

    public String getmechanicOfCarLastName() {
        return mechanicOfCarLastName;
    }

    public void setmechanicOfCarLastName(String mechanicOfCarLastName) {
        this.mechanicOfCarLastName = mechanicOfCarLastName;
    }

    public String getmechanicOfCarEmailAddress() {
        return mechanicOfCarEmailAddress;
    }

    public void setmechanicOfCarEmailAddress(String mechanicOfCarEmailAddress) {
        this.mechanicOfCarEmailAddress = mechanicOfCarEmailAddress;
    }

    public int getcarId() {
        return carId;
    }

    public void setcarId(int carId) {
        this.carId = carId;
    }

    public String getcarName() {
        return carName;
    }

    public void setcarName(String carName) {
        this.carName = carName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", description='" + description + '\'' +
                ", statusName='" + statusName + '\'' +
                ", mechanicId='" + mechanicId + '\'' +
                ", mechanicOfCarFirstName='" + mechanicOfCarFirstName + '\'' +
                ", mechanicOfCarLastName='" + mechanicOfCarLastName + '\'' +
                ", mechanicOfCarEmailAddress='" + mechanicOfCarEmailAddress + '\'' +
                '}';
    }
}