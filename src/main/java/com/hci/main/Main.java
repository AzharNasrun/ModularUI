package com.hci.main;

import org.springframework.boot.SpringApplication;

public class Main {


    public static void main(String args[]) {
        try {
            SpringApplication.run(new Class[]{SpringBootStarter.class},args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
