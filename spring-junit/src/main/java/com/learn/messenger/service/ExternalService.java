package com.learn.messenger.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {
    public String getExternalMessage() {
        return "Real External Message";
    }
}
