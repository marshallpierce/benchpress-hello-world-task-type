package com.palominolabs.benchpress.example.helloworld;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.palominolabs.benchpress.job.id.Id;
import com.palominolabs.benchpress.job.json.Partition;
import com.palominolabs.benchpress.job.json.Task;
import com.palominolabs.benchpress.job.task.TaskPartitioner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Id(HelloWorldTaskPartitioner.TASK_TYPE)
final class HelloWorldTaskPartitioner implements TaskPartitioner {

    static final String TASK_TYPE = "HELLO-WORLD";

    @Override
    public List<Partition> partition(UUID jobId, int workers, String progressUrl, String finishedUrl,
        ObjectReader objectReader, JsonNode jsonNode, ObjectWriter objectWriter) throws IOException {
        List<Partition> partitions = new ArrayList<Partition>();

        for (int i = 0; i < workers; i++) {
            // no need to modify config
            partitions.add(new Partition(jobId, i, new Task(TASK_TYPE, jsonNode), progressUrl, finishedUrl));
        }

        return partitions;
    }
}
