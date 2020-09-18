package com.learncamel.routes.bean;

import com.learncamel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    public void configure() throws Exception {

        from("direct:beanInput")
                .log("~~~~~Before bean the message is ${body}~~~~")
                .bean(new CamelBean())
                .log("~~~~~Changed Message is ${body}~~~~~")
        .to("mock:output");
    }
}
