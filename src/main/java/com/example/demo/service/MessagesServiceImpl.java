package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class MessagesServiceImpl implements MessagesService{

    private final MessageSource msg;

    private Student student;
    public MessagesServiceImpl(MessageSource msg) {
        this.msg = msg;
    }

    @Override
    public void sayHello() {
        System.out.println(msg.getMessage(
                "message.get-name",
                null,
                Locale.getDefault()
        ));
        Scanner sc = new Scanner(System.in);
        student = new Student(sc.nextLine());


        System.out.println(msg.getMessage(
                "message.start-message",
                new String[] {student.name()},
                Locale.getDefault()
        ));

    }

    @Override
    public void sayResult(Boolean result) {
        String codeMessage = (result) ? "message.success" : "message.fail";
        System.out.println(msg.getMessage(
                codeMessage,
                new String[] {student.name()},
                Locale.getDefault()
        ));
    }
}
