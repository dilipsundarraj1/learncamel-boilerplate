package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnMarshalUsingXStream extends RouteBuilder {
    public void configure() throws Exception {

        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());

        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());

        from("direct:xmlIn put")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");

    }
}
