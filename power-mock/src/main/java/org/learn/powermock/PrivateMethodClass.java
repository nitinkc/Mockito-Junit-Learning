package org.learn.powermock;

public class PrivateMethodClass {
    public String callPrivateMethod() {
        return privateMethod();
    }

    private String privateMethod() {
        return "Original Private Method";
    }
}

