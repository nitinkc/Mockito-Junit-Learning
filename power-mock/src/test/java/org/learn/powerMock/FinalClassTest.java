package org.learn.powerMock;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.powermock.FinalClass;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalClass.class)
public class FinalClassTest {

    @Test
    public void testFinalClass() throws Exception {
        FinalClass mockInstance = PowerMockito.mock(FinalClass.class);

        PowerMockito.whenNew(FinalClass.class).withNoArguments().thenReturn(mockInstance);
        PowerMockito.when(mockInstance.finalMethod()).thenReturn("Mocked Value");

        FinalClass instance = new FinalClass();
        Assert.assertEquals("Mocked Value", instance.finalMethod());
    }
}
