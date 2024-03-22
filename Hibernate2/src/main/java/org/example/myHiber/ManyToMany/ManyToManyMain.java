package org.example.myHiber.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMain {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        EmployeeMany employee1 = new EmployeeMany();
        EmployeeMany employee2 = new EmployeeMany();

        employee1.setEmployeeId(10);
        employee1.setEmployeeName("Ram");

        employee2.setEmployeeId(11);
        employee2.setEmployeeName("kuldeep");

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setProjectId(20);
        project1.setProjectName("Library management system");

        project2.setProjectId(21);
        project2.setProjectName("ticket booking");


        List<EmployeeMany> list1 = new ArrayList<>();
        List<Project>  list2 = new ArrayList<>();

        list1.add(employee1);
        list1.add(employee2);

        list2.add(project1);
        list2.add(project2);

        employee1.setProjects(list2);
        project2.setEmployees(list1);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        transaction.commit();
        session.close();
        factory.close();

    }
}
