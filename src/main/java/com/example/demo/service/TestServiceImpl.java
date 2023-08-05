package com.example.demo.service;

import com.example.demo.config.TestConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class TestServiceImpl implements TestService {

    private final List<String> listOfQuestions;

    private final List<String> listOfAnswers;

    private final List<Integer> listOfScopes;

    private final int minimumScope;

    private int scope;

    public TestServiceImpl(TestConfig config) {
        this.listOfQuestions = config.getListOfQuestions();
        this.listOfAnswers = config.getListOfAnswers();
        this.listOfScopes = config.getListOfScopes();
        this.minimumScope = config.getMinimumScope();
    }

    @Override
    public void startTest() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 1; i<=listOfQuestions.size(); i++) {
                System.out.println("" + i + ": " + listOfQuestions.get(i - 1));
                String answer = "";
                if (sc.hasNext()) {
                    answer = sc.nextLine();
                }

                if (answer.equals(listOfAnswers.get(i - 1))) {
                    scope += listOfScopes.get(i - 1);
                }
            }
        }
    }

    @Override
    public boolean getTestResult() {
        return scope >= minimumScope;
    }
}
