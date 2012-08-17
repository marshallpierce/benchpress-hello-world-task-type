package com.palominolabs.benchpress.example.helloworld;

import com.palominolabs.benchpress.job.task.TaskFactory;
import com.palominolabs.benchpress.task.reporting.TaskProgressClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

final class HelloWorldTaskFactory implements TaskFactory {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldTaskFactory.class);

    private final HelloWorldConfig config;

    public HelloWorldTaskFactory(HelloWorldConfig config) {
        this.config = config;
    }

    @Override
    public Collection<Runnable> getRunnables(UUID jobId, int partitionId, UUID workerId,
        TaskProgressClient taskProgressClient, AtomicInteger reportSequence) throws IOException {

        Set<Runnable> runnables = new HashSet<Runnable>();

        runnables.add(new Runnable() {
            @Override
            public void run() {
                logger.info("Greeting: " + config.getGreeting() + ", " + config.getTarget() + config.getPunctuation());
            }
        });

        return runnables;
    }

    @Override
    public void shutdown() {
        // no op
    }
}
