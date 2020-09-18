package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import com.learncamel.processor.CustomProcessorXStream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXStream extends RouteBuilder {
    public void configure() throws Exception {

        from("direct:csvInput")
                .process(new CustomProcessorXStream())
        .marshal(populateStreamDef())
//        .marshal().xstream()
        .to("log:?level=INFO&showBody=true")
        .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef(){
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());

        xStreamDataFormat.setAliases((aliases));

        return xStreamDataFormat;
    }
}
