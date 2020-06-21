package net.hello.domain;

import java.util.Date;

public class Member implements java.io.Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private double bonus;

    public Member() {

    }

    public Member(int id, String firstName, String lastName, Date birthDate,
            double bonus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return String.format("%d, %s %s, %s, %.2f",
                id, firstName, lastName, birthDate, bonus);
    }

}
