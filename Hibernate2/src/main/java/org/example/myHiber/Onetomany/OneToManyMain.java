package org.example.myHiber.Onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyMain {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // creating departments
        Department hrDepartment = new Department();
        hrDepartment.setDepartmentName("HR");

        Department itDepartment = new Department();
        itDepartment.setDepartmentName("IT");

        // creating employees
        Employee employee1 = new Employee();
        employee1.setEmployeeName("omkar");
        employee1.setDepartment(hrDepartment);

        Employee employee2 = new Employee();
        employee2.setEmployeeName("kuldeep");
        employee2.setDepartment(itDepartment);

        // adding employee to department
        List<Employee> hrEmployees = new ArrayList<>();
        hrEmployees.add(employee1);
        hrDepartment.setEmployees(hrEmployees);

        List<Employee> itEmployees = new ArrayList<>();
        itEmployees.add(employee2);
        itDepartment.setEmployees(itEmployees);

        // session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // save departments and employees
        session.save(hrDepartment);
        session.save(itDepartment);
        session.save(employee1);
        session.save(employee2);

        transaction.commit();

        // Feaching the data

        Department fetchedHrDepartment = session.get(Department.class, hrDepartment.getDepartmentId());
        System.out.println("Department Name: "+fetchedHrDepartment.getDepartmentName());
        System.out.println("Employees in HR Department: ");
        for(Employee employee : fetchedHrDepartment.getEmployees()){
            System.out.println("Employee Name: "+employee.getEmployeeName());
        }

        session.close();
        factory.close();





    }

}
