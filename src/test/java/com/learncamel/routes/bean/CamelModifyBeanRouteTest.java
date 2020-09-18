package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {

        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest(){

        String expected = "123*jamieg*11141988";
        String input = "123,jamieg,11141988";

        String actual = (String) template.requestBody("direct:beanInput", input);
        assertEquals(expected, actual);

    }

}
