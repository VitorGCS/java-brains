package io.javabrains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCESS_CARD")
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issuedDate;
    private boolean isActive;
    private String firmwareVersion;

    @OneToOne(mappedBy = "card", fetch = FetchType.LAZY) //Indicates that in the Employee don't fetch the "card" property, because is this one
    private Employee owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
}
