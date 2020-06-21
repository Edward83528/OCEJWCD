package net.hello.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloServiceImpl implements HelloService {

    private final String[] MESSAGE = {"Hi", "Hello", "Good Morning"};
    
    public HelloServiceImpl() {
        System.out.println("HelloServiceImpl/constructor");
    }

    @Override
    public String greeting() {
        return MESSAGE[(int)(Math.random() * 3)];
    }

}
