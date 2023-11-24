package com.learn.messenger.service;

import org.apache.commons.lang3.StringUtils;

// SomeDependencyImpl.java
public class SomeDependencyImpl implements SomeDependency {

    @Override
    public String someMethod() {
        // Some implementation logic, for example, fetching data from a database
        StringUtils.getDigits("123");
        System.out.println("Do Something");
        StringUtils.getDigits("123");
        System.out.println("Do Something Else");
        StringUtils.getDigits("123");
        StringUtils.getDigits("123");
        System.out.println("StringUtils.getDigits is called 4 times");

        return "Real Result";
    }

    public String verifyMethod() {
        // Some implementation logic, for example, fetching data from a database
        return "Real Result";
    }
}

