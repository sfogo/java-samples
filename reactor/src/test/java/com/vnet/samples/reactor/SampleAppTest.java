package com.vnet.samples.reactor;

import org.testng.annotations.Test;

public class SampleAppTest {
    @Test
    public void testApp() {
        final SampleApp app = new SampleApp();
        app.run("how", "long", "can", "we", "go", "on", "like", "this", "?");
    }
}
