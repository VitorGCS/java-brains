package io.javabrains.springbootjpaexample.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "EMPLOYEE_FROM_SBA")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_name", length = 120)
    private String name;

    @Column(nullable = true)
    private Integer age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
