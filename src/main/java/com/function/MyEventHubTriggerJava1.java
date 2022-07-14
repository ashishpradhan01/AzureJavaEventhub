package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.*;

/**
 * Azure Functions with Event Hub trigger.
 */
public class MyEventHubTriggerJava1 {
    /**
     * This function will be invoked when an event is received from Event Hub.
     */
    @FunctionName("MyEventHubTriggerJava1")
    public void run(
        @EventHubTrigger(name = "message", eventHubName = "master-hub", connection = "connectionString", consumerGroup = "$Default", cardinality = Cardinality.MANY, dataType = "string") List<String> message,
        final ExecutionContext context
    ) {
        context.getLogger().info("Java Event Hub trigger function executed.");
        context.getLogger().info("Length:" + message.size());
        context.getLogger().info("All Messages: ");
        for (String string : message) {
            context.getLogger().info(string);
        }
       
    }
}
