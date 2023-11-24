package com.nitin.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UuidUtilsTest {

    @Test
    void getUuidId() {
        try(MockedStatic<UuidUtils> utilities = Mockito.mockStatic(UuidUtils.class)){
            UUID uuid = UUID.randomUUID();
            Mockito.when(UuidUtils.getUuidId("12345")).thenReturn(uuid.toString());

            Map<String, String> uuidIdToStringIdMap = UuidUtils.getUuidIdToStringIdMap(Arrays.asList("12345"));
            String uuidId = UuidUtils.getUuidId("12345");

            System.out.println("Mocked method called: " + Mockito.mockingDetails(UuidUtils.class).getInvocations());

            Assertions.assertEquals(uuid.toString(), uuidId);

            //Assertions.assertEquals(Map.of(uuid,"12345"), UuidUtils.getUuidIdToStringIdMap(Arrays.asList("12345")));
        }
    }
}