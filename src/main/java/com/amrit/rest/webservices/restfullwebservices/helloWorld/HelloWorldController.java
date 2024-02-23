package com.amrit.rest.webservices.restfullwebservices.helloWorld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/helloWorldBean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloWorld/pathVariable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping(path="/another")
    public String anotherTest(){
        HelloWorldBean helloWorldBean = new HelloWorldBean("Another");
        return helloWorldBean.toString();
    }

    @GetMapping("/helloWorldInternationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//        return "Hello World";
    }


}
