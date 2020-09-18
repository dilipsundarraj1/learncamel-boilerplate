package com.learncamel.bean;

import org.apache.camel.builder.RouteBuilder;

public class CamelBean {

    public String map(String input){

        String newBody = input.replace(",","*");

        return newBody;
    }

}
