package com.learncamel.recipientlist;

import org.apache.camel.Exchange;

public class RecipientEIPProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String employeeType =
                exchange.getIn().getHeader("type", String.class);
        System.out.println("~~~~~~~~~~ EXCHANGE HEADER BELOW ~~~~~~~~~");
        System.out.println(exchange.getIn());
        if (employeeType.equals("senior")) {
            exchange.getIn().setHeader("type", "file:xmlsenior");
        } else {
            exchange.getIn().setHeader("type", "file:xmljunior");
        }

    }
}
