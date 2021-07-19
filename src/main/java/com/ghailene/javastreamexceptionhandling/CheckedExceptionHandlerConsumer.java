package com.ghailene.javastreamexceptionhandling;


@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target,ExObj extends Exception> {

public void accept(Target target) throws ExObj;
}
