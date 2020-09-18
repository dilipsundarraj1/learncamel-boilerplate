package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXStreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new UnMarshalUsingXStream();
    }

    @Test
    public void UnMarshalXStreamTest() throws InterruptedException {

        Employee employee = new Employee();
        employee.setJoinDate("11141988");
        employee.setName("jamieg");
        employee.setId("123");

        String xmlInput="<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>jamieg</name><joinDate>11141988</joinDate></employee>";

        MockEndpoint ep = getMockEndpoint("mock:output");
        ep.expectedBodiesReceived(employee.toString());
        template.sendBody("direct:xmlInput",xmlInput);

        assertMockEndpointsSatisfied();


    }
}

