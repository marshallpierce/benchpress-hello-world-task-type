package com.palominolabs.benchpress.example.helloworld;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.palominolabs.benchpress.job.task.TaskFactoryFactory;
import com.palominolabs.benchpress.job.task.TaskPartitioner;

public final class HelloWorldModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), TaskFactoryFactory.class).addBinding()
            .to(HelloWorldTaskFactoryFactory.class);
        Multibinder.newSetBinder(binder(), TaskPartitioner.class).addBinding().to(HelloWorldTaskPartitioner.class);
    }
}
