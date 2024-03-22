package org.example.myHiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataDemo {
    public static void main(String[] args) {
        System.out.printf("Project Started");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        //Get-student : 1
        Student student=(Student)session.load(Student.class, 3);
        System.out.println(student);

        Address ad = (Address) session.get(Address.class,1);
        System.out.println(ad.getStreet()+" : "+ad.getCity());
    }

}
