package com.mixalismavromanolakis.car_service_tasks.DTO;

import com.mixalismavromanolakis.car_service_tasks.Entities.Mechanic;

public class MechanicDTO {

    public int mechanicId;
    public String mechanicLastName;
    public String mechanicFirstName;
    public String mechanicEmailAddress;

    public MechanicDTO() {
    }

    public MechanicDTO(int mechanicId, String mechanicLastName, String mechanicFirstName, String mechanicEmailAddress) {
        this.mechanicId = mechanicId;
        this.mechanicLastName = mechanicLastName;
        this.mechanicFirstName = mechanicFirstName;
        this.mechanicEmailAddress = mechanicEmailAddress;
    }

    public MechanicDTO(Mechanic mechanicEntity) {
        this.mechanicId = mechanicEntity.getMechanicId();
        this.mechanicFirstName = mechanicEntity.getFirstName();
        this.mechanicLastName = mechanicEntity.getLastName();
        this.mechanicEmailAddress = mechanicEntity.getEmailAddress();
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getMechanicLastName() {
        return mechanicLastName;
    }

    public void setMechanicLastName(String mechanicLastName) {
        this.mechanicLastName = mechanicLastName;
    }

    public String getMechanicFirstName() {
        return mechanicFirstName;
    }

    public void setMechanicFirstName(String mechanicFirstName) {
        this.mechanicFirstName = mechanicFirstName;
    }

    public String getMechanicEmailAddress() {
        return mechanicEmailAddress;
    }

    public void setMechanicEmailAddress(String mechanicEmailAddress) {
        this.mechanicEmailAddress = mechanicEmailAddress;
    }

    @Override
    public String toString() {
        return "MechanicDTO{" +
                "mechanicId=" + mechanicId +
                ", mechanicLastName='" + mechanicLastName + '\'' +
                ", mechanicFirstName='" + mechanicFirstName + '\'' +
                ", mechanicEmailAddress='" + mechanicEmailAddress + '\'' +
                '}';
    }
}
