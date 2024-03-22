package org.example.myHiber.Onetomany;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="employee_id")
    private int emploeeId;
    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(int emploeeId, String employeeName, Department department) {
        this.emploeeId = emploeeId;
        this.employeeName = employeeName;
        this.department = department;
    }

    public Employee() {
    }


    public int getEmploeeId() {
        return emploeeId;
    }

    public void setEmploeeId(int emploeeId) {
        this.emploeeId = emploeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
