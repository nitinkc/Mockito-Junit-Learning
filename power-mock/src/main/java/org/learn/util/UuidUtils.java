package org.learn.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UuidUtils {
  /**
   * Gets map UUID id to String id using specified id list.
   *
   * @param idList - list used to construct map.
   * @return patient id to mpi map
   */
  public static Map<String, String> getUuidIdToStringIdMap(List<String> idList) {
    return idList.stream()
        .collect(Collectors.toMap(UuidUtils::getUuidId, Function.identity()));
  }

  /**
   * Gets list of corresponding user ids for specified mpi list.
   *
   * @param idList - mpi list to convert to patient list.
   * @return list of patient ids
   */
  public static List<String> getUuidIds(Collection<String> idList) {
    return idList.stream()
        .map(UuidUtils::getUuidId)
        .collect(Collectors.toList());
  }

  /**
   * Gets UUId id by specified String id.
   *
   * @param id used to get corresponding UUID id.
   * @return patient id
   */
  public static String getUuidId(String id) {
    return UUID.nameUUIDFromBytes(id.getBytes(StandardCharsets.UTF_8)).toString();
  }

  public static UUID fromStringKey(String key) {
    Objects.requireNonNull(key, "Key must not be null.");
    return UUID.nameUUIDFromBytes(key.getBytes(StandardCharsets.UTF_8));
  }

}