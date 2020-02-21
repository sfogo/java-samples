package com.vnet.apps.words.pyramid;

import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.BeforeSuite;

public class PyramidFinderTest {
    private final PyramidFinder finder = new PyramidFinder();

    @BeforeSuite
    public void before() {
        ReflectionTestUtils.invokeSetterMethod(finder, "maxLength", 100);
        finder.init();
    }
}
