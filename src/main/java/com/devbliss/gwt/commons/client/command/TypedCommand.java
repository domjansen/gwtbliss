package com.devbliss.gwt.commons.client.command;

/**
 * 
 * A typed command to use in a command pattern, an object of type <C> must be pass to the
 * execute method.
 * 
 * @param <T>
 * 
 * @author akoeberle
 */
public interface TypedCommand<T> {
    /**
     * Execute the command with a given object passed in.
     * 
     * @param object
     */
    void execute(T object);
}
