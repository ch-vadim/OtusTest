package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "test")
@Component
@Setter
@Getter
public class TestConfig {

    private List<String> listOfQuestions;

    private List<String> listOfAnswers;

    private List<Integer> listOfScopes;

    private int minimumScope;
}
