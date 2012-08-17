package com.palominolabs.benchpress.example.helloworld;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.palominolabs.benchpress.job.id.Id;
import com.palominolabs.benchpress.job.task.TaskFactory;
import com.palominolabs.benchpress.job.task.TaskFactoryFactory;

import java.io.IOException;

@Id("HELLO-WORLD")
final class HelloWorldTaskFactoryFactory implements TaskFactoryFactory {
    @Override
    public TaskFactory getTaskFactory(ObjectReader objectReader, JsonNode jsonNode) throws IOException {
        HelloWorldConfig config = objectReader.withType(HelloWorldConfig.class).readValue(jsonNode);

        return new HelloWorldTaskFactory(config);
    }
}
