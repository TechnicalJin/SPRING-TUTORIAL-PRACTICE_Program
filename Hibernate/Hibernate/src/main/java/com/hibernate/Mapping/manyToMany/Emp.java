package com.hibernate.Mapping.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emp {

    @Id
    private int eid;

    @Column(name = "project_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "ManyToMany")
    private List<Project> projects;

    public Emp() {
        super();
    }

    public Emp(int eid, String name, List<Project> projects) {
        super();
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }
}
