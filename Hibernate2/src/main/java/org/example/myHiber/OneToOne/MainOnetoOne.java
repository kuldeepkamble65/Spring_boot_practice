package org.example.myHiber.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainOnetoOne {
    public static void main(String[] args) {

        //  System.out.printf("Hello and welcome!");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // creating question
        Question question = new Question();
        question.setQuestionId(1);
        question.setQuestion("What is java ?");

        // creating answer
        Answer answer = new Answer();
        answer.setAnswerId(2);
        answer.setAnswer("java is programming langauge");
        answer.setQuestion(question);
        question.setAnswer(answer);


        // creating question
        Question question2 = new Question();
        question2.setQuestionId(3);
        question2.setQuestion("What is collection Framework ?");

        // creating answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(4);
        answer2.setAnswer("API to work with objects in java");
        answer2.setQuestion(question2);
        question2.setAnswer(answer2);

        //session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question);
        session.save(question2);
        session.save(answer);
        session.save(answer2);

        transaction.commit();
        //feching

        Question newque=(Question) session.get(Question.class,1);
        System.out.println(newque.getQuestion());
        System.out.println(newque.getAnswer().getAnswer());

        Question newque1=(Question) session.get(Question.class,3);
        System.out.println(newque1.getQuestion());
        System.out.println(newque1.getAnswer().getAnswer());

        session.close();
        factory.close();
    }
}
