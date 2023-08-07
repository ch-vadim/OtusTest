package com.example.demo.shell;

import com.example.demo.service.MessagesService;
import com.example.demo.service.TestService;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;


@ShellComponent
public class TestShellCommandController {

    private final TestService testService;

    private final MessagesService messagesService;

    private boolean isLogin;

    public TestShellCommandController(TestService testService, MessagesService messagesService) {
        this.testService = testService;
        this.messagesService = messagesService;
    }

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public void login() {
        messagesService.sayHello();
        isLogin = true;
    }

    @ShellMethod(value = "Start test", key = {"s", "start"})
    @ShellMethodAvailability(value = "isStartTestMethodAvailable")
    public void startTest() {
        testService.startTest();
        messagesService.sayResult(testService.getTestResult());
    }

    private Availability isStartTestMethodAvailable() {
        return isLogin ? Availability.available() : Availability.unavailable("You should log in");
    }
}
