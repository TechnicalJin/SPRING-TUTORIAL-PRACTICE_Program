package com.hibernate.Mapping.manyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {

    @Id
    private int pid;
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;


    public Project() {
        super();
    }

    public Project(int pid, String projectName, List<Emp> emps) {
        super();
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", projectName='" + projectName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
