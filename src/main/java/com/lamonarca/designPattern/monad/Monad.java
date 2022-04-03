package com.lamonarca.designPattern.monad;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.lamonarca.MyLogger.logger;

public class Monad {

    public static void TryCatchMonad() {

        // the old way
        int value;
        String badFormattedInt = "10xcsd";
        try {
            value = Integer.parseInt(badFormattedInt);
        } catch (NumberFormatException e) {
            value = 10;
        }
        logger.info("value : {}", value);

        // our new way
        int value2 = Try.ofThrowable(() -> Integer.valueOf(badFormattedInt)).orElse(10);
        logger.info("value2 : {}", value2);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        logger.info("Monad main");

        Optional<String> optionalValue = Optional.of("hello world").map(String::toUpperCase);
        logger.info("optionalValue : {}", optionalValue.get());

        Stream<String> streamValues = Stream.of("Hello", "World").map(String::toUpperCase);
        logger.info("streamValues : {}", streamValues.collect(Collectors.joining(" ")));

        CompletableFuture<String> futureValues = CompletableFuture
                .supplyAsync(() -> "Hello World")
                .thenApply(String::toUpperCase);
        logger.info("futureValues : {}", futureValues.get());


        Monad.TryCatchMonad();
    }
}
