package com.lamonarca.designPattern.monad;

class Success<U> extends Try<U> {

    private final U value;
    Success(U value) {
        this.value = value;
    }

    @Override
    public U get() {
        return value;
    }

    @Override
    public U orElse(U value) {
        return this.value;
    }

}