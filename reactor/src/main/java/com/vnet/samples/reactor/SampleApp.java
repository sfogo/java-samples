package com.vnet.samples.reactor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleApp {
    public void run(final String... args) {
        for (String arg : args) {
            log.info("{}", arg);
        }
    }
}
