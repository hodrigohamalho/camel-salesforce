package org.redhat;

import org.apache.camel.builder.RouteBuilder;

public class HelloRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        
        from("timer:live-demo?repeatCount=1")
            .log("hello world!")
            .to("salesforce:query"
                + "?sObjectQuery=SELECT Id, Name, Lastname FROM Lead"
                + "&sObjectName=Lead"
                + "&sObjectClass=org.apache.camel.salesforce.dto.Lead")
            .log("${body}");
        
    }
    
}
