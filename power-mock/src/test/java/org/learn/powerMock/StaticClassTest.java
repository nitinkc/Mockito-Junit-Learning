package org.learn.powerMock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.powermock.MyStaticClass;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MyStaticClass.class)
public class StaticClassTest {

    @Test
    public void testStaticMethod() {
        PowerMockito.mockStatic(MyStaticClass.class);

        PowerMockito.when(MyStaticClass.staticMethod()).thenReturn("Mocked Value");

        Assert.assertEquals("Mocked Value", MyStaticClass.staticMethod());
    }
}
