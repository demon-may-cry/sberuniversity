package ru.sberuniversity.concurrent.proxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class ArgsKey implements Serializable {
    @Serial
    private static final long serialVersionUID = -5599141198497637305L;
    private final Object[] args;

    public ArgsKey(Object[] args) {
        this.args = args;
    }

    public Object getArgs() {
        return args.getClass().isArray() ? Arrays.toString(args) : args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgsKey argsKey = (ArgsKey) o;
        return Objects.deepEquals(args, argsKey.args);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(args);
    }
}
