package com.apu.mongodb.springbootmongodb.sequence_generator;

import java.util.concurrent.ExecutionException;

public interface ISequenceGeneratorService {
    long generateSequence(final String sequenceName) throws InterruptedException, ExecutionException;
}
