package org.learn.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UuidUtils.class, UUID.class})
public class UuidUtilsTest {

    @Test
    public void getUuidId() {
        try (MockedStatic<UuidUtils> utilities = Mockito.mockStatic(UuidUtils.class)) {
            UUID uuid = UUID.randomUUID();
            Mockito.when(UuidUtils.getUuidId("12345")).thenReturn(uuid.toString());

            PowerMockito.mockStatic(UUID.class);
            Mockito.when(UUID.randomUUID()).thenReturn(uuid);

            List<String> inputList = Arrays.asList("12345");
            Map<String, String> uuidIdToStringIdMap = UuidUtils.getUuidIdToStringIdMap(inputList);

            System.out.println("Expected Map: " + Map.of(uuid, "12345"));
            System.out.println("Actual Map: " + uuidIdToStringIdMap);
            System.out.println("Mocked method called: " + Mockito.mockingDetails(UuidUtils.class).printInvocations());

            Assertions.assertEquals(Map.of(uuid, "12345"), uuidIdToStringIdMap);
        }
    }
}