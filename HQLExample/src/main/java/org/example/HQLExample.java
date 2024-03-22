package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // HQL syntax
        Session session = factory.openSession();
        Student st = new Student();
        st.setId(3);
        st.setName("vaibhav");
        st.setCity("pune");
        System.out.println(st);
        session.save(st);

        Student st2 = new Student();
        st2.setId(4);
        st2.setName("kuldeep");
        st2.setCity("kolhapur");
        System.out.println(st2);

        Student st3 = new Student();
        st3.setId(5);
        st3.setName("ram");
        st3.setCity("mumbai");
        System.out.println(st3);

        Student st4 = new Student();
        st4.setId(6);
        st4.setName("sham");
        st4.setCity("sangli");
        System.out.println(st4);


        session.save(st2);
        session.save(st3);
        session.save(st4);

        Transaction transaction = session.beginTransaction();
        transaction.commit();

        String query = "from Student where city='pune'";

       Query q  =  session.createQuery(query);
       // single result - unique
        // multiple list
        List<Student> list=q.list();

        for(Student student : list){
            System.out.println(student.getName());
        }
        System.out.println("--------------------------------------------------");
        Transaction transaction2 = session.beginTransaction();
//          Delete query
//        Query q2 = session.createQuery("delete from Student as s where s.city=:c");
//       q2.setParameter("c","mumbai");
//        int r =  q2.executeUpdate();
//        System.out.println("deleted");
//        System.out.println(r);

        Query q3 = session.createQuery("update Student set city=:c where name=:n");
        q3.setParameter("c", "goa");
        q3.setParameter("n","kolhapur");
        int r=q3.executeUpdate();
        System.out.println("Updated");
        System.out.println(r+" Rows updated");


        transaction2.commit();

        session.close();
        factory.close();



    }
}
