package org.learn.powerMock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.powermock.PrivateMethodClass;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateMethodClass.class)
public class PrivateMethodClassTest {

    @Test
    public void testPrivateMethod() throws Exception {
        PrivateMethodClass mockInstance = PowerMockito.mock(PrivateMethodClass.class);

        PowerMockito.when(mockInstance, "privateMethod").thenReturn("Mocked Value");

        Assert.assertEquals("Mocked Value", mockInstance.callPrivateMethod());
    }
}
