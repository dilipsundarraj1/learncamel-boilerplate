package com.learncamel.routes.transform;

import org.apache.camel.Route;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new CamelModifyTransformRoute();
    }

    @Test
    public void transformTest(){
        String expected="123*jamie*11141988";
        String input="123,jamie,11141988";

        String actual=(String) template.requestBody("direct:transformInput", input);

        assertEquals(expected, actual);
    }
}
