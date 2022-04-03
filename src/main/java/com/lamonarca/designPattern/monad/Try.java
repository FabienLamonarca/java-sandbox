package com.lamonarca.designPattern.monad;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class Try<U> {

    public abstract U get() throws Throwable;

    public abstract U orElse(U value);

    public static <U> Try<U> ofThrowable(Supplier<U> f) {
        Objects.requireNonNull(f);
        try {
            return Try.successful(f.get());
        } catch (Throwable e) {
            return Try.failure(e);
        }
    }

    public static <U> Success<U> successful(U u) {
        return new Success<>(u);
    }

    public static <U> Failure<U> failure(Throwable e) {
        return new Failure<>(e);
    }
}
