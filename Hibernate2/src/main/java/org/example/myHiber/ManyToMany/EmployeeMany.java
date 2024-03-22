package org.example.myHiber.ManyToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class EmployeeMany {
    @Id
    private int employeeId;
    private String employeeName;
    @ManyToMany
    private List<Project> projects;

    public EmployeeMany(int employeeId, String employeeName, List<Project> projects) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.projects = projects;
    }

    public EmployeeMany() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
