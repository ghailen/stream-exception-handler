package com.ghailene.javastreamexceptionhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.StreamExceptionHandler;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JavaStreamExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStreamExceptionHandlingApplication.class, args);

        List<String> list = Arrays.asList("44", "373", "xyz");
        list.forEach(StreamExceptionHandler.handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));


        List<Integer> listInteger = Arrays.asList(1, 0);
        listInteger.forEach(StreamExceptionHandler.handleGenericException(s -> System.out.println(10 / s), ArithmeticException.class));


        //handle exception for checkedException
        List<Integer> list2 = Arrays.asList(10, 20);
        list2.forEach(StreamExceptionHandler.handleCheckedExceptionConsumer(i ->
                {
                    Thread.sleep(i);
                    System.out.println(i);
                }


        ));

    }


}
