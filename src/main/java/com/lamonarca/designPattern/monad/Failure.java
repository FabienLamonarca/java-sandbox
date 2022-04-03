package com.lamonarca.designPattern.monad;

class Failure<U> extends Try<U> {

    private final Throwable e;

    Failure(Throwable e) {
        this.e = e;
    }

    @Override
    public U get() throws Throwable {
        throw e;
    }

    @Override
    public U orElse(U value) {
        return value;
    }
}
