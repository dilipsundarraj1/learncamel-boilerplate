package com.learncamel.processor;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessorXStream implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(newBody, ",");

        Employee employee = new Employee();
        while(tokenizer.hasMoreElements()){
            employee.setId((String) tokenizer.nextElement());
            employee.setName((String) tokenizer.nextElement());
            employee.setJoinDate((String) tokenizer.nextElement());
        }

        exchange.getIn().setBody(employee);
    }
}
