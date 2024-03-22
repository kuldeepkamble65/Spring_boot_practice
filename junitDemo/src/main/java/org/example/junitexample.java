package org.example;

import org.junit.*;

public class junitexample {
    static int beforeClassCount = 1;
    static int afterClassCount=1;
    static int beforeCount = 1;
    static int afterCount = 1;

    @Before
    public void setup(){
        System.out.println("Execution count of before method is:"+beforeCount++);

    }
    @BeforeClass
    public static void setBeforeClassCount(){
        System.out.println("Execution count of beforeclass method is:"+beforeClassCount++);

    }
    @Test
    public void test1(){
        System.out.println("code for test1 method goes here");
    }
    @Test
    public void test2(){
        System.out.println("code for test2 method goes here");
    }
    @Test
    public void test3(){
        System.out.println("code for test3 method goes here");
    }
    @Test
    public void test4(){
        System.out.println("code for test4 method goes here");
    }
    @Test
    public void test5(){
        System.out.println("code for test5 method goes here");
    }
    @After
    public void tearDown(){
        System.out.println("Execution count of after method is:"+afterCount++);

    }
    @AfterClass
    public static void tearDownclass(){
        System.out.println("Execution count of after method is:"+afterClassCount++);

    }

}
