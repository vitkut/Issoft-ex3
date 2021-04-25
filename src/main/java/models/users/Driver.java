package models.users;

import services.IdGenerator;

public class Driver extends User {

    private String licenseId;

    public Driver(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
        this.licenseId = IdGenerator.generateId(4);
    }

    public String getLicenseId() {
        return licenseId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "licenseId='" + licenseId + '\'' +
                ", " + super.toString() +
                '}';
    }
}
