package com.learn.messenger.service;

// Calculator.java
public class Calculator {

    public Integer add(Integer a, Integer b) {
        if(null != a && null != b){
            return a + b;
        }
        else
            throw new IllegalArgumentException("numbers cannot be null" + " a = " + a + " b = "+ b);
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }
}

