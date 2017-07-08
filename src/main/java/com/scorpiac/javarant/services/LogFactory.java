package com.scorpiac.javarant.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LogFactory {
    private LogFactory() {
    }

    public static Logger getLog() {
        return LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}