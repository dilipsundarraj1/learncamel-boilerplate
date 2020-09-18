package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXStreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){

        return new MarshalUsingXStream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {

        String input = "123,jamieg,11141988";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><com.learncamel.domain.Employee><id>123</id><name>jamieg</name><joinDate>11141988</joinDate></com.learncamel.domain.Employee>";

        MockEndpoint mock=getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();

    }

    @Test
    public void marshalXstreamTest_Employee_alias() throws InterruptedException {

        String input = "123,jamieg,11141988";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>jamieg</name><joinDate>11141988</joinDate></employee>";

        MockEndpoint mock=getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();

    }

}
