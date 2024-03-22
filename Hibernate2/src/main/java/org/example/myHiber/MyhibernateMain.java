package org.example.myHiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MyhibernateMain {
    public static void main(String[] args)throws IOException {

        System.out.printf("Project Started");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
       Student st = new Student();
        st.setId(3);
        st.setName("vaibhav");
        st.setEmail("vaibhav56@abc.com");
        st.setAddress("mumbai");
        System.out.println(st);



        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("pune");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.23);
// Reading image
        FileInputStream fis = new FileInputStream("/home/perennial/Downloads/Hibernate2/src/image.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(st);
        session.save(ad);
        transaction.commit();
        session.close();
        System.out.println("Done..");


    }
}