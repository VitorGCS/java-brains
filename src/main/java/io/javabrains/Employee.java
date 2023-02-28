package io.javabrains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query="select e from Employee e where e.age > :age order by e.name ", name="emp name asc")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_name", length = 120)
    private String name;

    @Column(nullable = true)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;

    @Transient
    private String debugString;

    @OneToOne(fetch = FetchType.LAZY)
    private AccessCard card;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<PayStub> payStubs = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTION",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_EMAIL_ID"))
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public void addPayStub(PayStub payStub) {
        this.payStubs.add(payStub);
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroup) {
        this.emailGroups = emailGroup;
    }

    public void addEmailSubscription(EmailGroup emailGroup) {
        this.emailGroups.add(emailGroup);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
