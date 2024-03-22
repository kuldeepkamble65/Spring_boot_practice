package com.WithoutMavenHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Student st = new Student();
        st.setId(1);
        st.setName("kuldeep");
        st.setCity("kolhapur");
        System.out.println(st);


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(st);
        transaction.commit();
        session.close();

    }
}