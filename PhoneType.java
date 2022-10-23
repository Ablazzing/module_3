package org.example;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneType {
  @NonNull
    String name;
  @NonNull
    String code;
  @NonNull
    @ToString.Exclude
    boolean isMobile;

}