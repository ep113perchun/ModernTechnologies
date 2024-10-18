package ru.home.app.types;

public interface Number {
    Number copy() throws Exception;
    Number add(Number value) throws Exception;
    Number subtract(Number value) throws Exception;
    Number multiply(Number value) throws Exception;
    Number divide(Number value) throws Exception;
    String toString();
}
