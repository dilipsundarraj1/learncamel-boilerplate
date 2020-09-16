package com.learncamel.routes;


import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        Thread.sleep( 5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
    }
}
