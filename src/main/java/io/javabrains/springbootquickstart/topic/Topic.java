package io.javabrains.springbootquickstart.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    private String idtop;
    private String name;
    private String description;

    public Topic() {
    }

    public Topic(String idtop, String name, String description) {
        this.idtop = idtop;
        this.name = name;
        this.description = description;
    }

    public String getIdtop() {
        return idtop;
    }

    public void setIdtop(String id) {
        this.idtop = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
