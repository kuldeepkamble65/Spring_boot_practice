package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

      //  System.out.printf("Hello and welcome!");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // creating question
        Question question = new Question();
        question.setQuestionId(1212);
        question.setQuestion("What is java ?");

        // creating answer
        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("java is programming langauge");
        question.setAnswer(answer);


        // creating question
        Question question2 = new Question();
        question2.setQuestionId(242);
        question2.setQuestion("What is collection Framework ?");

        // creating answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(343);
        answer2.setAnswer("API to work with objects in java");
        question2.setAnswer(answer2);

        //session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question);
        session.save(question2);

        transaction.commit();

        factory.close();
    }
}