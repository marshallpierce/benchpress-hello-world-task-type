package com.palominolabs.benchpress.example.helloworld;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.concurrent.Immutable;

@Immutable
final class HelloWorldConfig {

    private final String greeting;
    private final String target;
    private final String punctuation;

    @JsonCreator
    HelloWorldConfig(@JsonProperty("greeting") String greeting, @JsonProperty("target") String target,
        @JsonProperty("punctuation") String punctuation) {
        this.greeting = greeting;
        this.target = target;
        this.punctuation = punctuation;
    }

    @JsonProperty("greeting")
    public String getGreeting() {
        return greeting;
    }

    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @JsonProperty("punctuation")
    public String getPunctuation() {
        return punctuation;
    }
}
